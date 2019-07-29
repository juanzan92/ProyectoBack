package tesis.services.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import tesis.entities.builders.dynamo.ItemBuilder;
import tesis.entities.dtos.item.Item;
import tesis.services.RestClient;

@Service
public class ItemService {
    @Autowired
    RestClient restClient;

    String urlBase = "https://kusmq1it9k.execute-api.us-east-1.amazonaws.com/prod/items/";

    public Item getItem(String itemId) throws JsonProcessingException {
        return restClient.request(urlBase + itemId + "/item_id", null, HttpMethod.GET, Item.class);
    }

    public String saveItem(Item item) throws JsonProcessingException {
        return restClient.request(urlBase + "/item_id", ItemBuilder.saveItem(item), HttpMethod.PUT, String.class);
    }

    public String deleteItem(String itemId) throws JsonProcessingException {
        return restClient.request(urlBase + itemId + "/item_id", null, HttpMethod.DELETE, String.class);
    }
}
