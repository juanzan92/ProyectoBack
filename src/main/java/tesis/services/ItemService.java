package tesis.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import tesis.entities.dtos.Items;

@Service
public class ItemService {

    @Autowired
    RestClient restClient;

    String urlBase = "https://lrxqme2z7k.execute-api.us-east-1.amazonaws.com/Prod/items";
    String urlBaseSearch = "https://kusmq1it9k.execute-api.us-east-1.amazonaws.com/prod/items";

    public String createItem(Items newItem) throws JsonProcessingException {
        return restClient.request(urlBase + "/create_item", newItem, HttpMethod.POST);
    }

    // Continuar de aca con la funcion de buscqueda - parametrizar category+index
    public String getItemByName(Items newItem, String index, String pattern ) throws JsonProcessingException {
        return restClient.request(urlBaseSearch + "/natacion/category/RESERVED", newItem, HttpMethod.GET);
    }



}
