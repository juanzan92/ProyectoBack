package tesis.services.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import tesis.entities.dtos.account.User;
import tesis.entities.dtos.mercadopago.Consumer;
import tesis.entities.dtos.mercadopago.Vendor;
import tesis.services.RestClient;

import javax.validation.constraints.NotNull;

@Service
public class UserService {

    @Autowired
    RestClient restClient;

    String urlBase = "https://lrxqme2z7k.execute-api.us-east-1.amazonaws.com/Prod/users";

    public String createUser(@NotNull User newUser) throws JsonProcessingException {
        return restClient.request(urlBase, newUser, HttpMethod.POST, String.class);
    }

    public String createVendorUser(@NotNull Vendor vendor, @NotNull String username) throws JsonProcessingException {
        return restClient.request(urlBase, vendor, HttpMethod.PUT, String.class);
    }

    public Vendor getVendor(@NotNull String user) throws JsonProcessingException {
        return restClient.request(urlBase + "/get_user", user, HttpMethod.GET, Vendor.class);
    }

    public Consumer getConsumer(@NotNull String user) throws JsonProcessingException {
        return restClient.request(urlBase + "/get_user", user, HttpMethod.GET, Consumer.class);
    }
}
