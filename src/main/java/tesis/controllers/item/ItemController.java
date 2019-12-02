package tesis.controllers.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mercadopago.exceptions.MPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.item.Item;
import tesis.services.item.ItemService;

import java.util.ArrayList;
import java.util.Map;

@RestController
@CrossOrigin(allowedHeaders = "*", maxAge = 3600, allowCredentials = "true")
@RequestMapping("/catalog/items")
public class ItemController {
    @Autowired
    ItemService itemService;

    @PostMapping("/listing/{category}")
    public ArrayList<Item> listingCategories(@PathVariable String category, @RequestBody Map<String, Map> param) throws JsonProcessingException {
        return itemService.getListing(category, param);
    }

    @PostMapping()
    public String createItem(@RequestBody Item item) throws JsonProcessingException {
        return itemService.createItem(item);
    }

    @GetMapping()
    public Item getItem(@RequestParam Map<String, String> item_id) throws JsonProcessingException {
        return itemService.getItem(item_id);
    }

    @GetMapping("/get_all")
    public Item[] getAllItem() throws JsonProcessingException {
        return itemService.getAllItem();
    }

    @GetMapping("/get_filtered")
    public Item[] getAllFiltered(@RequestParam String filter) throws JsonProcessingException {
        return itemService.getAllFiltered(filter);
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
    public String cancelItem(@RequestParam("item_id") String itemId) throws JsonProcessingException, MPException {
        return itemService.cancelItem(itemId);
    }
}
