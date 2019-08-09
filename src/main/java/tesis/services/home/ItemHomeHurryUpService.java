package tesis.services.home;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import tesis.entities.builders.dynamo.DynamoBuilder;
import tesis.entities.dtos.ForDynamo;
import tesis.entities.dtos.home.ItemHomeHurryUp;
import tesis.services.RestClient;

import java.util.Map;

@Service
public class ItemHomeHurryUpService {
    @Autowired
    RestClient restClient;
    String urlBase = "https://rtge19cj13.execute-api.us-east-1.amazonaws.com/prod/generic_ep";
    ForDynamo forDynamo = new ForDynamo("items_home", "item_id");

    public String createItemHomeHurryUp(ItemHomeHurryUp itemHomeHurryUp) throws JsonProcessingException {
        itemHomeHurryUp.setTag("HurryUp");
        return restClient.request(urlBase, DynamoBuilder.saveObject(itemHomeHurryUp, forDynamo), HttpMethod.POST, String.class);
    }

    public ItemHomeHurryUp[] searchItemsHomeHurryUp(Map<String, String> param) throws JsonProcessingException {
        return restClient.request(DynamoBuilder.searchObjects(param, forDynamo, urlBase + "/index_search"), HttpMethod.GET, ItemHomeHurryUp[].class);
    }

}
