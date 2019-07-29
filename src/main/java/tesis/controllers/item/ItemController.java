package tesis.controllers.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.item.Item;
import tesis.services.item.ItemService;

@RestController
@RequestMapping("/catalog/items")
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping("/{id}")
    public Item getItem(@PathVariable("id") String itemId) throws JsonProcessingException {
        return itemService.getItem(itemId);
    }

    @GetMapping("/search")
    public Item searchItems(@RequestBody Item item) throws JsonProcessingException {
        return itemService.searchItems(item);
    }

    @PostMapping("/{id}")
    public String createItem(@RequestBody Item item) throws JsonProcessingException {
        return itemService.createItem(item);
    }

    @PutMapping("/{id}")
    public String saveItem(@RequestBody Item item) throws JsonProcessingException {
        return itemService.saveItem(item);
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable("id") String itemId) throws JsonProcessingException {
        return itemService.deleteItem(itemId);
    }
}
