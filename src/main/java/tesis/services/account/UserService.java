package tesis.services.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import tesis.entities.builders.dynamo.CognitoBuilder;
import tesis.entities.builders.dynamo.DynamoBuilder;
import tesis.entities.dtos.ForCognito;
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

    String urlBase = "https://rtge19cj13.execute-api.us-east-1.amazonaws.com/prod/user_ep";
    ForDynamo forDynamo = new ForDynamo("users", "username");
    ForCognito forCognito = new ForCognito();

    public String createUser(@NotNull User user) throws JsonProcessingException {
        return restClient.request(urlBase, DynamoBuilder.saveObject(user, forDynamo), HttpMethod.POST, String.class);
    }

    public User getUser(Map<String, String> param) throws JsonProcessingException {
        return restClient.request(DynamoBuilder.getObject(param, forDynamo, urlBase), HttpMethod.GET, User.class);
    }

    public User[] getAllUser() throws JsonProcessingException {
        return restClient.request(DynamoBuilder.getAllObject(forDynamo, urlBase + "/get_all"), HttpMethod.GET, User[].class);
    }

    public User[] searchUsers(@NotNull String filter, @NotNull String value) throws JsonProcessingException {
        forDynamo.setIndexName(filter);
        forDynamo.setSearchPattern(value);
        return restClient.request(DynamoBuilder.searchObjects(forDynamo, urlBase + "/index_search"), HttpMethod.GET, User[].class);
    }

    public User searchUser(@NotNull String filter, @NotNull String value) throws JsonProcessingException {
        User[] users = restClient.request(DynamoBuilder.searchObjects(DynamoBuilder.buildSearchParameters(forDynamo, filter, value), urlBase + "/index_search"), HttpMethod.GET, User[].class);
        return users[0];
    }

    public String deleteUser(Map<String, String> username) throws JsonProcessingException {
        forCognito.setUserPoolId("us-east-1_vwGNEHsur");
        restClient.request(urlBase + "/cognito", CognitoBuilder.deleteObject(username, forCognito ), HttpMethod.DELETE, String.class);
        return restClient.request(urlBase, DynamoBuilder.getObject(username, forDynamo), HttpMethod.DELETE, String.class);
    }

    public String createVendorUser(Vendor vendor) throws JsonProcessingException {
        return restClient.request(urlBase, DynamoBuilder.saveObject(vendor, forDynamo), HttpMethod.PUT, String.class);
    }

    public Vendor getVendor(@NotNull Map<String, String> param) throws JsonProcessingException {
        return restClient.request(DynamoBuilder.getObject(param, forDynamo, urlBase), HttpMethod.GET, Vendor.class);
    }

    public Vendor[] getAllVendor() throws JsonProcessingException {
        return restClient.request(DynamoBuilder.getAllObject(forDynamo, urlBase + "/get_all"), HttpMethod.GET, Vendor[].class);
    }

    public Consumer getConsumer(@NotNull Map<String, String> param) throws JsonProcessingException {
        return restClient.request(DynamoBuilder.getObject(param, forDynamo, urlBase), HttpMethod.GET, Consumer.class);
    }
}
