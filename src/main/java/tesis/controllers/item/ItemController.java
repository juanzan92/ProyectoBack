package tesis.controllers.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.item.Item;
import tesis.services.item.ItemService;

@RestController
@RequestMapping("/catalog/items/{id}")
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping()
    public Item getItem(@PathVariable("id") String itemId) throws JsonProcessingException {
        return itemService.getItem(itemId);
    }

    @PostMapping()
    public String saveItem(@RequestBody Item item) throws JsonProcessingException {
        return itemService.saveItem(item);
    }

    @DeleteMapping()
    public String deleteItem(@PathVariable("id") String itemId) throws JsonProcessingException {
        return itemService.deleteItem(itemId);
    }
}
