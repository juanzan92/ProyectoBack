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

    public static Map getObject(Map<String, String> param, ForDynamo forDynamo) {
        HashMap<String, Map> body = bodyParameters(forDynamo);
        body.put("object", param);
        return body;
    }

    public static String getObject(Map<String, String> param, ForDynamo forDynamo, String urlbase) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(urlbase)
                .queryParams(buildMultiValueMap(forDynamo))
                .queryParams(buildMultiValueMap(param));
        return uriComponentsBuilder.toUriString();
    }

    public static String getObject(Object param, ForDynamo forDynamo, String urlbase) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(urlbase)
                .queryParams(buildMultiValueMap(forDynamo))
                .queryParams(buildMultiValueMap(param));
        return uriComponentsBuilder.toUriString();
    }

    public static String getAllObject(ForDynamo forDynamo, String urlbase) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(urlbase)
                .queryParams(buildMultiValueMap(forDynamo));
        return uriComponentsBuilder.toUriString();
    }

    public static String searchObjects(Map<String, String> param, ForDynamo forDynamo, String urlbase) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(urlbase)
                .queryParams(buildMultiValueMap(forDynamo))
                .queryParams(buildMultiValueMap(param));
        return uriComponentsBuilder.toUriString();
    }

    public static String searchObjects(ForDynamo forDynamo, String urlbase) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(urlbase)
                .queryParams(buildMultiValueMap(forDynamo));
        return uriComponentsBuilder.toUriString();
    }

    public static HashMap bodyParameters(ForDynamo forDynamo) {
        HashMap<String, ForDynamo> dynamoItem = new HashMap<>();
        dynamoItem.put("dynamo", forDynamo);
        return dynamoItem;
    }

    public static HashMap buildMap(String parameter, String value) {
        HashMap<String, String> user = new HashMap<>();
        user.put(parameter, value);
        return user;
    }

    public static MultiValueMap buildMultiValueMap(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        MultiValueMap parameters = new LinkedMultiValueMap<String, String>();
        Map<String, String> maps = objectMapper.convertValue(object, new TypeReference<Map<String, String>>() {
        });
        parameters.setAll(maps);
        return parameters;
    }

    public static ForDynamo buildSearchParameters(ForDynamo forDynamo, String filter, String value) {
        forDynamo.setIndexName(filter);
        forDynamo.setSearchPattern(value);
        return forDynamo;
    }
}
