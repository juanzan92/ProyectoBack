package tesis.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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

    public <T> T request(String url, Object body, HttpMethod httpMethod, Class<T> responseClass) throws JsonProcessingException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String newObject = objectMapper.writeValueAsString(body);

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<>(newObject, headers);

            return restTemplate.exchange(url, httpMethod, entity, responseClass).getBody();

        } catch (Exception e) {
            throw e;
        }
    }

    //yerbas
    public <T> T request(String url, HttpMethod httpMethod, Class<T> responseClass) throws JsonProcessingException {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<>(headers);

            return restTemplate.exchange(url, httpMethod, entity, responseClass).getBody();

        } catch (Exception e) {
            throw e;
        }
    }

    public <T> T formRequest(String url, MultiValueMap<String, String> requestBody, Class<T> responseClass) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            HttpEntity entity = new HttpEntity<>(requestBody, headers);

            return restTemplate.exchange(url, HttpMethod.POST, entity, responseClass).getBody();
        } catch (Exception e) {
            throw e;
        }
    }
}
