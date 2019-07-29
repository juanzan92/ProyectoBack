package tesis.entities.builders.dynamo;

import com.fasterxml.jackson.databind.ObjectMapper;
import tesis.entities.dtos.ForDynamo;
import tesis.entities.dtos.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemBuilder {
    private static ForDynamo forDynamo = new ForDynamo("items", "itemId");

    public static Map buildDynamo(Item item) {
        HashMap<String, Map> dynamoItem = new HashMap<>();
        queryParameteres(dynamoItem);

        Map<String, Object> map = new ObjectMapper().convertValue(item, Map.class);
        dynamoItem.put("object", map);

        return dynamoItem;
    }

    public static void queryParameteres(HashMap<String, Map> dynamoItem) {
        dynamoItem.put("dynamo", new ObjectMapper().convertValue(forDynamo, Map.class));
    }
}
