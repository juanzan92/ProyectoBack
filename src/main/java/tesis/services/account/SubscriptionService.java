package tesis.services.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import tesis.entities.builders.dynamo.DynamoBuilder;
import tesis.entities.dtos.ForDynamo;
import tesis.entities.dtos.account.Subscription;
import tesis.entities.dtos.item.Item;
import tesis.entities.enums.item.ItemStatus;
import tesis.entities.enums.user.SubscriptionStatus;
import tesis.services.RestClient;
import tesis.services.item.ItemService;

import java.util.Map;

@Service
public class SubscriptionService {
    @Autowired
    RestClient restClient;

    @Autowired
    ItemService itemService;

    String urlBase = "https://rtge19cj13.execute-api.us-east-1.amazonaws.com/prod/generic_ep";
    ForDynamo forDynamo = new ForDynamo("subscriptions", "subscription_id");

    public Subscription createSubscription(Subscription subscription) throws JsonProcessingException {
        try {
            Item item = itemService.getItem(DynamoBuilder.buildMap("item_id", subscription.getItemId()));
            int newItemQuantity = item.getStock() - subscription.getQuantity();
            item.setStock(newItemQuantity);

            if (newItemQuantity == 0) item.setStatus(ItemStatus.COMPLETED);

            itemService.updateItem(item);
            return restClient.request(urlBase, DynamoBuilder.saveObject(subscription, forDynamo), HttpMethod.POST, Subscription.class);
        } catch (Exception e) {
            throw e;
        }
    }

    public Subscription getSubscription(Map<String, String> param) throws JsonProcessingException {
        return restClient.request(DynamoBuilder.getObject(param, forDynamo, urlBase), HttpMethod.GET, Subscription.class);
    }

    public Subscription[] getAllSubscription() throws JsonProcessingException {
        return restClient.request(DynamoBuilder.getAllObject(forDynamo, urlBase + "/get_all"), HttpMethod.GET, Subscription[].class);
    }

    public Subscription[] searchSubscription(Map<String, String> param) throws JsonProcessingException {
        return restClient.request(DynamoBuilder.searchObjects(param, forDynamo, urlBase + "/index_search"), HttpMethod.GET, Subscription[].class);
    }

    public String updateSubscription(Subscription subscription) throws JsonProcessingException {
        return restClient.request(urlBase, DynamoBuilder.saveObject(subscription, forDynamo), HttpMethod.PUT, String.class);
    }

    public String deleteSubscription(Map<String, String> param) throws JsonProcessingException {
        return restClient.request(urlBase, DynamoBuilder.getObject(param, forDynamo), HttpMethod.DELETE, String.class);
    }

    public String cancelSubscription(String subscriptionId) throws JsonProcessingException {
        try {
            Subscription subscription = getSubscription(DynamoBuilder.buildMap("subscription_id", subscriptionId));

            if (subscription.getSubscriptionStatus() != SubscriptionStatus.IN_PROGRESS) {
                throw new IllegalStateException("Subscription already FINISHED. Nothing Done");
            }

            subscription.setSubscriptionStatus(SubscriptionStatus.CANCELLED);

            Item item = itemService.getItem(DynamoBuilder.buildMap("item_id", subscription.getItemId()));
            item.setStock(item.getStock() + subscription.getQuantity());
            if (item.getStatus() == ItemStatus.COMPLETED) item.setStatus(ItemStatus.ACTIVE);

            itemService.updateItem(item);

            return updateSubscription(subscription);
        } catch (Exception e) {
            throw e;
        }
    }

}
