package tesis.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tesis.dtos.entities.PocDTO;

import java.util.Arrays;

@Service
public class PocDynamoService {

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public PocDTO prueba() {
        String urlstr = "https://kusmq1it9k.execute-api.us-east-1.amazonaws.com/Stage/asfasdfa/bf4efe76-deab-4c58-bda2-56c546b08fa4";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        PocDTO pocDTO = restTemplate.exchange(urlstr, HttpMethod.GET, entity, PocDTO.class).getBody();

        return pocDTO;
    }
}
