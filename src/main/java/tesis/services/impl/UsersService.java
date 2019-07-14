package tesis.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tesis.dtos.entities.PocDTO;
import tesis.dtos.entities.Users;

import java.util.Arrays;

@Service
public class UsersService {

    @Autowired
    RestTemplate restTemplate;
    /*@Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }*/
    //private String dynamo_table = "Users";

    /*public Users createUser(String id,String role){
        Users user = new Users(id,role);
        return user;
    }*/

    public Users getUserHC(String user_id){
        Users user = new Users();
        user.setUserId("54565465456");
        user.setUserRole("collaborador");
        user.setName("Yerbon");
        return user;
    }

    public Users get_user_by_id(String user_id) {
        Users user = new Users();

        String urlstr = "https://kusmq1it9k.execute-api.us-east-1.amazonaws.com/prod/{items}/{id}/{attribute}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        // HttpEntity<String> entity = new HttpEntity<String>(headers);

        //setting up the request body
        HttpEntity<Users> requestEntity = new HttpEntity<>(user, headers);

        ResponseEntity<Users> responseEntity = restTemplate.exchange(
                urlstr,
                HttpMethod.GET,
                requestEntity,
                Users.class
        );
        return user;
    }


    public void create_user_hc() {
        String urlstr = "https://lrxqme2z7k.execute-api.us-east-1.amazonaws.com/Prod/users/create_user";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
       // HttpEntity<String> entity = new HttpEntity<String>(headers);

        //setting up the request body
        Users user = new Users();
        user.setName("PostmanBackEnd01");
        user.setUserRole("collaborador");
        user.setUserId("1231231231");

        HttpEntity<Users> requestEntity = new HttpEntity<>(user, headers);

        ResponseEntity<Users> responseEntity = restTemplate.exchange(
                urlstr,
                HttpMethod.POST,
                requestEntity,
                Users.class
        );
        //String response = restTemplate.exchange(urlstr, HttpMethod.POST, entity, String.class).getBody();
     }

    public void create_user(Users user) {
        String urlstr = "https://lrxqme2z7k.execute-api.us-east-1.amazonaws.com/Prod/users/create_user";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        // HttpEntity<String> entity = new HttpEntity<String>(headers);

        //setting up the request body
        HttpEntity<Users> requestEntity = new HttpEntity<>(user, headers);

        ResponseEntity<Users> responseEntity = restTemplate.exchange(
                urlstr,
                HttpMethod.POST,
                requestEntity,
                Users.class
        );

    }

}
