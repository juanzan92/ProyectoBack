package tesis.controllers;

        import com.fasterxml.jackson.databind.JsonNode;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpEntity;
        import org.springframework.http.HttpHeaders;
        import org.springframework.http.HttpMethod;
        import org.springframework.http.MediaType;
        import org.springframework.web.bind.annotation.*;
        import tesis.dtos.entities.PocDTO;
        import tesis.services.impl.PocService;

        import java.util.Arrays;
        import java.util.HashMap;
        import java.util.Map;


        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.context.annotation.Bean;
        import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class DBController {
    public static void main(String[] args) {
        SpringApplication.run(DBController.class, args);
    }
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    @RestController
    public class ConsumeWebService {
        @Autowired
        RestTemplate restTemplate;

        @RequestMapping(value = "/poc/getItemDB")
        public String getProductList() {
            String urlstr = "https://kusmq1it9k.execute-api.us-east-1.amazonaws.com/Stage/asfasdfa/bf4efe76-deab-4c58-bda2-56c546b08fa4";
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<String>(headers);

            return restTemplate.exchange(urlstr, HttpMethod.GET, entity, String.class).getBody();
        }
    }
        /*
        @GetMapping("/poc/getItemDB")
        //public JsonNode getItemDB()
        public String getItemDB()
        {
        }
        */
}