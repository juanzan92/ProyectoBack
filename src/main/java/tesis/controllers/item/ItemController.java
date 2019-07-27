package tesis.controllers.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tesis.entities.dtos.item.Item;
import tesis.services.item.ItemService;

@RestController
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping("/catalog/items/get_item")
    public Item getUser(@RequestParam String itemId) throws JsonProcessingException {
        return itemService.getItem(itemId);
    }
}
