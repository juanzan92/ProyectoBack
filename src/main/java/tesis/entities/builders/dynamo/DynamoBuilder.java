package tesis.entities.builders.dynamo;

import tesis.entities.dtos.ForDynamo;

import java.util.HashMap;
import java.util.Map;

public class DynamoBuilder {

    public static <T> Map saveObject(T object, ForDynamo forDynamo) {
        HashMap<String, T> body = queryParameters(forDynamo);

        body.put("object", object);

        return body;
    }

    public static Map getObject(Map<String, String> param, ForDynamo forDynamo) {
        HashMap<String, Map> body = queryParameters(forDynamo);
        body.put("search_parameter", param);
        return body;
    }

    public static HashMap queryParameters(ForDynamo forDynamo) {
        HashMap<String, ForDynamo> dynamoItem = new HashMap<>();

        dynamoItem.put("dynamo", forDynamo);

        return dynamoItem;
    }
}
