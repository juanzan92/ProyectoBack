package tesis.controllers.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import tesis.entities.builders.dynamo.DynamoBuilder;
import tesis.entities.dtos.item.Item;
import tesis.services.item.ItemService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/catalog/items")
public class ItemController {
    @Autowired
    ItemService itemService;

    @PostMapping()
    public String createItem(@RequestBody Item item) throws JsonProcessingException {
        return itemService.createItem(item);
    }

    @GetMapping()
    public Item getItem(@RequestBody Map<String, String> param) throws JsonProcessingException {
        // Negrada #1
        return itemService.getItem((MultiValueMap<String, String>) DynamoBuilder.convert2multi(param));
    }

    @GetMapping("/search")
    public Item[] searchItems(@RequestBody Map<String, String> param) throws JsonProcessingException {
        return itemService.searchItems(param);
    }

    @PutMapping()
    public String updateItem(@RequestBody Item item) throws JsonProcessingException {
        return itemService.updateItem(item);
    }

    @DeleteMapping()
    public String deleteItem(@RequestBody Map<String, String> param) throws JsonProcessingException {
        return itemService.deleteItem(param);
    }
}
