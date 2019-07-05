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

    public Users createUser(Long id,String role){
        Users user = new Users(id,role);
        return user;
    }

    @Autowired
    RestTemplate restTemplate;

    /*@Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }*/
    public Users getUser(Long user_id){
        Users user = new Users();
        user.setUserId(1234567879L);
        user.setUserRole("collaborador");
        user.setName("Yerbon");
        return user;
    }

    public void prueba_create() {
        String urlstr = " https://lrxqme2z7k.execute-api.us-east-1.amazonaws.com/Prod/users/create_user";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
       // HttpEntity<String> entity = new HttpEntity<String>(headers);

        //setting up the request body
        Users user = new Users();
        user.setName("PostmanBack");
        user.setUserRole("collaborador");
        user.setUserId(123456789L);

        HttpEntity<Users> requestEntity = new HttpEntity<>(user, headers);

        ResponseEntity<Users> responseEntity = restTemplate.exchange(
                urlstr,
                HttpMethod.POST,
                requestEntity,
                Users.class
        );
        //String response = restTemplate.exchange(urlstr, HttpMethod.POST, entity, String.class).getBody();

        /*
        {
            "name" :"PostmanBack",
            "title": "Mr"
        }
         */

     }

}
