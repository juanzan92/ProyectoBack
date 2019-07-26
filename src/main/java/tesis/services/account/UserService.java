package tesis.services.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import tesis.entities.dtos.account.Users;
import tesis.services.RestClient;

@Service
public class UserService {

    @Autowired
    RestClient restClient;

    String urlBase = "https://lrxqme2z7k.execute-api.us-east-1.amazonaws.com/Prod/users";

    public String createUser(Users newUser) throws JsonProcessingException {
        return restClient.request(urlBase + "/create_user", newUser, HttpMethod.POST);
    }

/*
    @Autowired
    RestClient restClient;

    public String createUser(Users newUser) {
        String urlstr = "https://lrxqme2z7k.execute-api.us-east-1.amazonaws.com/Prod/users/create_user";

       return restClient.request(urlstr, newUser, HttpMethod.POST);
    }
*/

}
