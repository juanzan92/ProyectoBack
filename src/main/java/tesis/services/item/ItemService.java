package tesis.services.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import tesis.entities.dtos.item.Item;
import tesis.services.RestClient;

@Service
public class ItemService {
    @Autowired
    RestClient restClient;
    String urlBase = "https://lrxqme2z7k.execute-api.us-east-1.amazonaws.com/Prod/users";

    public Item getItem(String item) throws JsonProcessingException {
        return restClient.request(urlBase + "/items/get_item", item, HttpMethod.GET, Item.class);
    }

    public String saveItem(Item item) {
        return "";
    }
}
