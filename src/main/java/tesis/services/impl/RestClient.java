package tesis.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;

@Service
public class RestClient {
    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public String request(String url, Object body, HttpMethod httpMethod) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String newObject = objectMapper.writeValueAsString(body);

            String urlstr = url + "?access_token=TEST-5912969040584293-092110-771d21ab7cc96c709fbcc464d05c409b-187271358";

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<>(newObject, headers);

            return restTemplate.exchange(urlstr, httpMethod, entity, String.class).getBody();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
