package tesis.services.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import tesis.entities.builders.dynamo.DynamoBuilder;
import tesis.entities.dtos.ForDynamo;
import tesis.entities.dtos.account.User;
import tesis.entities.dtos.mercadopago.Consumer;
import tesis.entities.dtos.mercadopago.Vendor;
import tesis.services.RestClient;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    RestClient restClient;
    //String urlBase = "https://lrxqme2z7k.execute-api.us-east-1.amazonaws.com/Prod/users";
    String urlBase = "https://rtge19cj13.execute-api.us-east-1.amazonaws.com/prod/generic_ep";
    ForDynamo forDynamo = new ForDynamo("users", "username");

    public String createUser(@NotNull User user) throws JsonProcessingException {
        return restClient.request(urlBase, DynamoBuilder.saveObject(user, forDynamo), HttpMethod.POST, String.class);
    }
        // Los Consumer de MP los vamos a guardar en la tabla Users???? //
    public Consumer getConsumer(@NotNull Map<String, String> param) throws JsonProcessingException {
        return restClient.request(DynamoBuilder.getObject(param, forDynamo, urlBase), HttpMethod.GET, Consumer.class);
    }
        // Falta Actualizar , el create vendor es solo un update del user para pasarlo a Vendor????? porque el PUT sino? //
        // Porque lleva 2 parametros de tipo persona la funcion? vendor y username????? //
    public String createVendorUser(@NotNull Vendor vendor, @NotNull String username) throws JsonProcessingException {
        return restClient.request(urlBase, DynamoBuilder.saveObject(vendor, forDynamo), HttpMethod.PUT, String.class);
    }
        // Los Vendors  de MP también los vamos a guardar en la tabla Users???? //
    public Vendor getVendor(@NotNull Map<String, String> param) throws JsonProcessingException {
        return restClient.request(DynamoBuilder.getObject(param, forDynamo, urlBase), HttpMethod.GET, Vendor.class);
    }


}
