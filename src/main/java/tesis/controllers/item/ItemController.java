package tesis.controllers.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.item.Item;
import tesis.services.item.ItemService;

@RestController
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping("/catalog/items/get_item")
    public Item getItem(@RequestParam String itemId) throws JsonProcessingException {
        return itemService.getItem(itemId);
    }

    @PostMapping("/catalog/items/save_item")
    public String saveItem(@RequestBody Item item) {
        return itemService.saveItem(item);
    }
}
