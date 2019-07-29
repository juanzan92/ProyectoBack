package tesis.entities.builders.dynamo;

import com.fasterxml.jackson.databind.ObjectMapper;
import tesis.entities.dtos.ForDynamo;
import tesis.entities.dtos.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemBuilder {

    public static Map saveItem(Item item) {
        HashMap<String, Map> body = queryParameteres();

        body.put("object", new ObjectMapper().convertValue(item, Map.class));

        return body;
    }

    public static HashMap queryParameteres() {
        HashMap<String, Map> dynamoItem = new HashMap<>();

        dynamoItem.put("dynamo", new ObjectMapper().convertValue(new ForDynamo("items", "itemId"), Map.class));

        return dynamoItem;
    }
}
