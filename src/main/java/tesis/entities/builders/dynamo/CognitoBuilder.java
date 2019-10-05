package tesis.entities.builders.dynamo;

import com.fasterxml.jackson.databind.ObjectMapper;
import tesis.entities.dtos.ForCognito;

import java.util.HashMap;
import java.util.Map;


public class CognitoBuilder {

    public static Map deleteObject(Map<String, String> param, ForCognito forCognito) {
        ObjectMapper objectMapper = new ObjectMapper();
        forCognito.setUsername(param.get("username"));
        HashMap<String, Object> body = objectMapper.convertValue(forCognito, HashMap.class);
        return body;
    }
}
