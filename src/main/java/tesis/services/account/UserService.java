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

    String urlBase = "https://rtge19cj13.execute-api.us-east-1.amazonaws.com/prod/generic_ep";
    ForDynamo forDynamo = new ForDynamo("users", "username");

    public String createUser(@NotNull User user) throws JsonProcessingException {
        return restClient.request(urlBase, DynamoBuilder.saveObject(user, forDynamo), HttpMethod.POST, String.class);
    }

    public String createVendorUser(@NotNull Vendor vendor, @NotNull String username) throws JsonProcessingException {
        return restClient.request(urlBase, DynamoBuilder.saveObject(vendor, forDynamo), HttpMethod.PUT, String.class);
    }

    public Vendor getVendor(@NotNull Map<String, String> param) throws JsonProcessingException {
        return restClient.request(DynamoBuilder.getObject(param, forDynamo, urlBase), HttpMethod.GET, Vendor.class);
    }

    public Consumer getConsumer(@NotNull Map<String, String> param) throws JsonProcessingException {
        return restClient.request(DynamoBuilder.getObject(param, forDynamo, urlBase), HttpMethod.GET, Consumer.class);
    }
}
