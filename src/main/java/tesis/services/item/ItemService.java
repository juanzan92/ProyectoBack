package tesis.services.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mercadopago.exceptions.MPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import tesis.entities.builders.dynamo.DynamoBuilder;
import tesis.entities.dtos.ForDynamo;
import tesis.entities.dtos.account.Subscription;
import tesis.entities.dtos.account.User;
import tesis.entities.dtos.item.Item;
import tesis.entities.enums.item.ItemStatus;
import tesis.services.RestClient;
import tesis.services.account.SubscriptionService;
import tesis.services.account.UserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ItemService {
    @Autowired
    UserService userService;

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    RestClient restClient;

    String urlBase = "https://rtge19cj13.execute-api.us-east-1.amazonaws.com/prod/generic_ep";
    ForDynamo forDynamo = new ForDynamo("items", "item_id");

    public String createItem(Item item) throws JsonProcessingException {
        try {
            User user = userService.getUser(DynamoBuilder.buildMap("username", item.getVendorUsername()));
            if (user == null) {
                throw new IllegalArgumentException("Vendor not found - Item Creation Canceled");
            }

            item.setStatus(ItemStatus.ACTIVE);
            item.setDateCreated(new Date());
            item.setLastUpdated(new Date());

            return restClient.request(urlBase, DynamoBuilder.saveObject(item, forDynamo), HttpMethod.POST, String.class);
        } catch (Exception e) {
            throw e;
        }
    }

    public Item getItem(Map<String, String> param) throws JsonProcessingException {
        return restClient.request(DynamoBuilder.getObject(param, forDynamo, urlBase), HttpMethod.GET, Item.class);
    }

    public Item[] getAllItem() throws JsonProcessingException {
        return restClient.request(DynamoBuilder.getAllObject(forDynamo, urlBase + "/get_all"), HttpMethod.GET, Item[].class);
    }

    public Item[] getAllFiltered(String filter) throws JsonProcessingException {
        forDynamo.setSearchPattern(filter);
        return restClient.request(DynamoBuilder.getAllObject(forDynamo, urlBase + "/scan_filtered"), HttpMethod.GET, Item[].class);
    }

    public Item[] searchItems(Map<String, String> param) throws JsonProcessingException {
        return restClient.request(DynamoBuilder.searchObjects(param, forDynamo, urlBase + "/index_search"), HttpMethod.GET, Item[].class);
    }

    public Item[] searchItems(ForDynamo forDynamo) throws JsonProcessingException {
        return restClient.request(DynamoBuilder.searchObjects(forDynamo, urlBase + "/index_search"), HttpMethod.GET, Item[].class);
    }

    public String updateItem(Item item) throws JsonProcessingException {
        Map<String, String> itemMap = DynamoBuilder.buildMap("item_id", item.getItemId());
        if (restClient.request(DynamoBuilder.getObject(itemMap, forDynamo, urlBase), HttpMethod.GET, Item.class) == null) {
            throw new IllegalArgumentException("Item not found - Item Update Canceled");
        }
        return restClient.request(urlBase, DynamoBuilder.saveObject(item, forDynamo), HttpMethod.PUT, String.class);
    }

    public String cancelItem(String itemId) throws JsonProcessingException, MPException {
        try {
            Item item = getItem(DynamoBuilder.buildMap("item_id", itemId));

            if (item.getStatus() != ItemStatus.ACTIVE) {
                throw new IllegalStateException("Item already FINISHED. Nothing to do");
            }

            HashMap<String, String> map = DynamoBuilder.buildMap("item_id", item.getItemId());
            map.put ("index_name","item_id");
            map.put ("search_pattern", item.getItemId());
            Subscription[] subscriptions = subscriptionService.searchSubscription(map);

            for (Subscription subscription : subscriptions) {
                subscriptionService.cancelSubscription(subscription.getSubscriptionId());
            }

            item.setStatus(ItemStatus.CANCELLED);

            return restClient.request(urlBase, DynamoBuilder.saveObject(item, forDynamo), HttpMethod.PUT, String.class);
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Item> getListing(String category, Map<String, Map> param) throws JsonProcessingException {
        try {
            Map price = param.get("price");

            forDynamo.setIndexName("category");
            forDynamo.setSearchPattern(category);
            Item[] items = searchItems(forDynamo);

            ArrayList<Item> filteredItems = new ArrayList<>();

            for (Item item : items) {
                float maxAmount = ((Integer) price.get("max_amount")).floatValue();
                float minAmount = ((Integer) price.get("min_amount")).floatValue();

                if (maxAmount >= item.getActualPrice() && minAmount <= item.getActualPrice())
                    filteredItems.add(item);
            }
            return filteredItems;
        } catch (Exception e) {
            throw e;
        }
    }
}
