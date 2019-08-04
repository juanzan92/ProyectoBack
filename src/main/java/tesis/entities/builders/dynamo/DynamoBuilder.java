package tesis.entities.builders.dynamo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;
import tesis.entities.dtos.ForDynamo;

import java.util.HashMap;
import java.util.Map;

public class DynamoBuilder {

    public static <T> Map saveObject(T object, ForDynamo forDynamo) {
        HashMap<String, T> body = bodyParameters(forDynamo);
        body.put("object", object);
        return body;
    }
    // Gabo
    public static Map getObject(Map<String, String> param, ForDynamo forDynamo) {
        HashMap<String, Map> body = bodyParameters(forDynamo);
        body.put("object", param);
        return body;
    }
    // Yerbas - Pasar
    public static String getObject(MultiValueMap<String, String> param, ForDynamo forDynamo, String urlbase) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(urlbase)
                .queryParam("table_name" , "items")
                .queryParam("table_primary", "item_id")
                //.queryParam("object_id", "666888")
                .queryParams(param);

        HashMap<String, Map> queryParam = queryParameters(forDynamo);
        return uriComponentsBuilder.toUriString();
    }

    public static Map searchObjects(Map<String, String> param, ForDynamo forDynamo) {
        HashMap<String, Map> body = bodyParameters(forDynamo);
        body.put("search_parameter", param);
        return body;
    }

    public static HashMap bodyParameters(ForDynamo forDynamo) {
        HashMap<String, ForDynamo> dynamoItem = new HashMap<>();
        dynamoItem.put("dynamo", forDynamo);
        return dynamoItem;
    }
    // Yerbas pasar a hashmap el objeto forDyanmo
    public static HashMap queryParameters(ForDynamo forDynamo) {
        HashMap<String, ForDynamo> dynamoItem = new HashMap<>();
        dynamoItem.put("dynamo", forDynamo);
        return dynamoItem;
    }

    public static MultiValueMap convert2multi (Object object){
        ObjectMapper objectMapper = new ObjectMapper();
        MultiValueMap parameters = new LinkedMultiValueMap<String, String>();
        Map<String, String> maps = objectMapper.convertValue(object, new TypeReference<Map<String, String>>() {});
        parameters.setAll(maps);

        return parameters;
    }
}
