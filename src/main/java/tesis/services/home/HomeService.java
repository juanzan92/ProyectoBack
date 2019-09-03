package tesis.services.home;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import tesis.entities.builders.dynamo.DynamoBuilder;
import tesis.entities.dtos.ForDynamo;
import tesis.entities.dtos.home.ItemCarrouselBottom;
import tesis.entities.dtos.home.ItemCarrouselMain;
import tesis.entities.dtos.home.ItemHurryUp;
import tesis.services.RestClient;

import java.util.Map;

@Service
public class HomeService {
    @Autowired
    RestClient restClient;
    String urlBase = "https://rtge19cj13.execute-api.us-east-1.amazonaws.com/prod/generic_ep";
    ForDynamo forDynamo = new ForDynamo("items_home", "item_id");

    public String createItemCarrouselMain(ItemCarrouselMain itemCarrouselMain) throws JsonProcessingException {
        itemCarrouselMain.setTag("CarrouselMain");
        return restClient.request(urlBase, DynamoBuilder.saveObject(itemCarrouselMain, forDynamo), HttpMethod.POST, String.class);
    }

    public ItemCarrouselMain[] searchItemsCarrouselMain() throws JsonProcessingException {
        forDynamo.setSearchParams("tag", "CarrouselMain");
        return restClient.request(DynamoBuilder.searchObjects(forDynamo, urlBase + "/index_search"), HttpMethod.GET, ItemCarrouselMain[].class);
    }

    public String updateItemCarrouselMain(ItemCarrouselMain itemCarrouselMain) throws JsonProcessingException {
        itemCarrouselMain.setTag("CarrouselMain");
        return restClient.request(urlBase, DynamoBuilder.saveObject(itemCarrouselMain, forDynamo), HttpMethod.PUT, String.class);
    }

    public String deleteItemCarrouselMain(Map<String, String> param) throws JsonProcessingException {
        return restClient.request(urlBase, DynamoBuilder.getObject(param, forDynamo), HttpMethod.DELETE, String.class);
    }

    public String createItemHurryUp(ItemHurryUp itemHurryUp) throws JsonProcessingException {
        itemHurryUp.setTag("HurryUp");
        return restClient.request(urlBase, DynamoBuilder.saveObject(itemHurryUp, forDynamo), HttpMethod.POST, String.class);
    }

    public ItemHurryUp[] searchItemsHurryUp() throws JsonProcessingException {
        forDynamo.setSearchParams("tag", "HurryUp");
        return restClient.request(DynamoBuilder.searchObjects(forDynamo, urlBase + "/index_search"), HttpMethod.GET, ItemHurryUp[].class);
    }

    public String updateItemHurryUp(ItemHurryUp itemHurryUp) throws JsonProcessingException {
        itemHurryUp.setTag("HurryUp");
        return restClient.request(urlBase, DynamoBuilder.saveObject(itemHurryUp, forDynamo), HttpMethod.PUT, String.class);
    }

    public String deleteItemHurryUp(Map<String, String> param) throws JsonProcessingException {
        return restClient.request(urlBase, DynamoBuilder.getObject(param, forDynamo), HttpMethod.DELETE, String.class);
    }

    public String createItemCarrouselBottom(ItemCarrouselBottom itemCarrouselBottom) throws JsonProcessingException {
        itemCarrouselBottom.setTag("CarrouselBottom");
        return restClient.request(urlBase, DynamoBuilder.saveObject(itemCarrouselBottom, forDynamo), HttpMethod.POST, String.class);
    }

    public ItemCarrouselBottom[] searchItemsCarrouselBottom() throws JsonProcessingException {
        forDynamo.setSearchParams("tag", "CarrouselBottom");
        return restClient.request(DynamoBuilder.searchObjects(forDynamo, urlBase + "/index_search"), HttpMethod.GET, ItemCarrouselBottom[].class);
    }

    public String updateItemCarrouselBottom(ItemCarrouselBottom itemCarrouselBottom) throws JsonProcessingException {
        itemCarrouselBottom.setTag("CarrouselBottom");
        return restClient.request(urlBase, DynamoBuilder.saveObject(itemCarrouselBottom, forDynamo), HttpMethod.PUT, String.class);
    }

    public String deleteItemCarrouselBottom(Map<String, String> param) throws JsonProcessingException {
        return restClient.request(urlBase, DynamoBuilder.getObject(param, forDynamo), HttpMethod.DELETE, String.class);
    }

}
