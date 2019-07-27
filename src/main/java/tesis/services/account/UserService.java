package tesis.services.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import tesis.entities.dtos.account.User;
import tesis.entities.dtos.mercadopago.Vendor;
import tesis.services.RestClient;

@Service
public class UserService {

    @Autowired
    RestClient restClient;

    String urlBase = "https://lrxqme2z7k.execute-api.us-east-1.amazonaws.com/Prod/users";

    public String createUser(User newUser) throws JsonProcessingException {
        return restClient.request(urlBase + "/create_user", newUser, HttpMethod.POST, String.class);
    }

    public String createVendorUser(Vendor vendor) throws JsonProcessingException {
        return restClient.request(urlBase + "/update_user", vendor, HttpMethod.PUT, String.class);
    }

}
