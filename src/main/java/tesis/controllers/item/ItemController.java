package tesis.controllers.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.item.Item;
import tesis.services.item.ItemService;

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
    public Item getItem(@RequestParam Map<String, String>  item_id) throws JsonProcessingException {
        return itemService.getItem(item_id);
    }

    @GetMapping("/get_all")
    public Item[] getAllItem() throws JsonProcessingException {
        return itemService.getAllItem();
    }

    @GetMapping("/search")
    public Item[] searchItems(@RequestParam Map<String, String> param) throws JsonProcessingException {
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
