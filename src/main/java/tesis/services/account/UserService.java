package tesis.services.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import tesis.entities.dtos.account.Users;
import tesis.services.RestClient;

@Service
public class UserService {

    @Autowired
    RestClient restClient;

    public String createUser(Users newUser) {
        String urlstr = "https://lrxqme2z7k.execute-api.us-east-1.amazonaws.com/Prod/users/create_user";

       return restClient.request(urlstr, newUser, HttpMethod.POST);
    }

}
