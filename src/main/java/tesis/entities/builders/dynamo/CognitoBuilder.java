package tesis.entities.builders.dynamo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;
import tesis.entities.dtos.ForCognito;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class CognitoBuilder {

    public static Map deleteObject(Map<String, String> param, ForCognito forCognito) {
        ObjectMapper objectMapper = new ObjectMapper();
        forCognito.setUsername(param.get("username"));
        HashMap<String, Object> body = objectMapper.convertValue(forCognito, HashMap.class);
        return body;
    }
}
