package tesis.services.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import tesis.entities.builders.dynamo.DynamoBuilder;
import tesis.entities.dtos.ForDynamo;
import tesis.entities.dtos.ForReports;
import tesis.entities.dtos.account.User;
import tesis.entities.dtos.item.Category;
import tesis.entities.dtos.item.Item;
import tesis.services.RestClient;
import tesis.services.account.UserService;

import java.util.Map;

@Service
public class ItemService {
    @Autowired
    UserService userService;

    @Autowired
    CategoryService categoryService;

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

    public Item[] searchItems(Map<String, String> param) throws JsonProcessingException {
        return restClient.request(DynamoBuilder.searchObjects(param, forDynamo, urlBase + "/index_search"), HttpMethod.GET, Item[].class);
    }

    public Item[] searchItems() throws JsonProcessingException {
        return restClient.request(DynamoBuilder.searchObjects(forDynamo, urlBase + "/index_search"), HttpMethod.GET, Item[].class);
    }

    public String updateItem(Item item) throws JsonProcessingException {
        Map<String, String> map_item_id = DynamoBuilder.buildMap("item_id", item.getItemId());
        if (restClient.request(DynamoBuilder.getObject(map_item_id, forDynamo, urlBase), HttpMethod.GET, Item.class) == null) {
            throw new IllegalArgumentException("Item not found - Item Update Canceled");
        }
        return restClient.request(urlBase, DynamoBuilder.saveObject(item, forDynamo), HttpMethod.PUT, String.class);
    }

    public String deleteItem(Map<String, String> param) throws JsonProcessingException {
        return restClient.request(urlBase, DynamoBuilder.getObject(param, forDynamo), HttpMethod.DELETE, String.class);
    }

    public ForReports[] getSoldItemsByCategories() throws JsonProcessingException {
        forDynamo.setIndexName("category");
        Category categories[] = categoryService.getAllCategory();
        ForReports forReports[] = new ForReports[categories.length];
        Item items[] = new Item[0];
        Integer i = 0;
        for (Category category : categories) {
            forReports[i] = new ForReports("",0,0,0);
            forReports[i].setSubject(category.getCategoryName());
            forDynamo.setSearchPattern(category.categoryName);
            items = searchItems();
            for (Item item : items) {
                forReports[i].setValueA(forReports[i].getValueA() + (item.getInitialStock() - item.getStock()));
                forReports[i].setValueB(forReports[i].getValueA());
                forReports[i].setFullMark(forReports[i].getValueA());
            }
            i++;
        }
        return forReports;
    }
}
