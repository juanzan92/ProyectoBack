package tesis.services.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import tesis.entities.builders.dynamo.DynamoBuilder;
import tesis.entities.dtos.ForDynamo;
import tesis.entities.dtos.ForReports;
import tesis.entities.dtos.account.Subscription;
import tesis.entities.dtos.item.Category;
import tesis.entities.dtos.item.Item;
import tesis.entities.enums.user.SubscriptionStatus;
import tesis.services.RestClient;
import tesis.services.item.CategoryService;
import tesis.services.item.ItemService;

import java.util.Map;

@Service
public class SubscriptionService {
    @Autowired
    RestClient restClient;

    @Autowired
    ItemService itemService;

    @Autowired
    CategoryService categoryService;

    String urlBase = "https://rtge19cj13.execute-api.us-east-1.amazonaws.com/prod/generic_ep";
    ForDynamo forDynamo = new ForDynamo("subscriptions", "subscription_id");

    public String createSubscription(Subscription subscription) throws JsonProcessingException {
        Item item = itemService.getItem(DynamoBuilder.buildMap("item_id", subscription.getItemId()));
        item.setStock(item.getStock() - subscription.getQuantity());
        itemService.updateItem(item);
        return restClient.request(urlBase, DynamoBuilder.saveObject(subscription, forDynamo), HttpMethod.POST, String.class);
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

    public Subscription[] searchSubscription() throws JsonProcessingException {
        return restClient.request(DynamoBuilder.searchObjects(forDynamo, urlBase + "/index_search"), HttpMethod.GET, Subscription[].class);
    }

    public String updateSubscription(Subscription subscription) throws JsonProcessingException {
        return restClient.request(urlBase, DynamoBuilder.saveObject(subscription, forDynamo), HttpMethod.PUT, String.class);
    }

    public String deleteSubscription(Map<String, String> param) throws JsonProcessingException {
        return restClient.request(urlBase, DynamoBuilder.getObject(param, forDynamo), HttpMethod.DELETE, String.class);
    }

    public String cancelSubscription(Subscription subscription) throws JsonProcessingException {
        try {
            subscription = getSubscription(DynamoBuilder.buildMap("subscription_id", subscription.getSubscriptionId()));
            if (subscription.getSubscriptionStatus() == SubscriptionStatus.CANCELLED) {
                throw new IllegalStateException("Subscription already CANCELLED. Nothing Done");
            }
            Item item = itemService.getItem(DynamoBuilder.buildMap("item_id", subscription.getItemId()));
            item.setStock(item.getStock() + subscription.getQuantity());
            itemService.updateItem(item);
            subscription.setSubscriptionStatus(SubscriptionStatus.CANCELLED);
            return updateSubscription(subscription);
        } catch (Exception e) {
            throw e;
        }
    }

    public ForReports[] getSubscriptionByCategories() throws JsonProcessingException {
        forDynamo.setIndexName("category_name");
        Category categories[] = categoryService.getAllCategory();
        ForReports forReports[] = new ForReports[categories.length];
        Subscription subscription[] = new Subscription[0];
        Integer i = 0;
        for (Category category: categories)
        {
            forReports[i] = new ForReports("",0,0,0);
            forReports[i].setSubject(category.getCategoryName());
            forDynamo.setSearchPattern(category.categoryName);
            subscription = searchSubscription();
            forReports[i].setSubject(category.getCategoryName());
            forReports[i].setValueA(subscription.length);
            forReports[i].setValueB(subscription.length);
            forReports[i].setFullMark(subscription.length);
            i++;
        }
        return forReports ;
    }
}
