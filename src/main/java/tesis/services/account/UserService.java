package tesis.services.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import tesis.entities.dtos.account.User;
import tesis.services.RestClient;

@Service
public class UserService {

    @Autowired
    RestClient restClient;

    String urlBase = "https://lrxqme2z7k.execute-api.us-east-1.amazonaws.com/Prod/users";

    public Object createUser(User newUser) {
        User user = (User) restClient.request(urlBase + "/create_user", newUser, HttpMethod.POST, User.class);
        return user;
    }

    public Object createVendorUser(User newUser){
        return restClient.request(urlBase + "/create_user", newUser, HttpMethod.POST, User.class);
    }

}
