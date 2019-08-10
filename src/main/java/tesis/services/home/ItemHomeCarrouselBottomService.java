package tesis.services.home;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import tesis.entities.builders.dynamo.DynamoBuilder;
import tesis.entities.dtos.ForDynamo;
import tesis.entities.dtos.home.ItemHomeCarrouselBottom;
import tesis.services.RestClient;

import java.util.Map;

@Service
public class ItemHomeCarrouselBottomService {
    @Autowired
    RestClient restClient;
    String urlBase = "https://rtge19cj13.execute-api.us-east-1.amazonaws.com/prod/generic_ep";
    ForDynamo forDynamo = new ForDynamo("items_home", "item_id");

    public String createItemHomeCarrouselBottom(ItemHomeCarrouselBottom itemHomeCarrouselBottom) throws JsonProcessingException {
        itemHomeCarrouselBottom.setTag("CarrouselBottom");
        return restClient.request(urlBase, DynamoBuilder.saveObject(itemHomeCarrouselBottom, forDynamo), HttpMethod.POST, String.class);
    }

    public ItemHomeCarrouselBottom[] searchItemsHomeCarrouselBottom() throws JsonProcessingException {
        forDynamo.setSearchParams("tag", "CarrouselBottom");
        return restClient.request(DynamoBuilder.searchObjects(forDynamo, urlBase + "/index_search"), HttpMethod.GET, ItemHomeCarrouselBottom[].class);
    }

}
