package tesis.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.Items;
import tesis.services.ItemService;


@RestController
public class ItemsController {
    @Autowired
    ItemService itemService;

    @PostMapping("/items/create_item")
    public String createItem(@RequestBody Items newItem) throws JsonProcessingException {
        return  itemService.createItem(newItem);
    }

    @GetMapping("/items/get_item")
    public String getItemByName(@RequestBody Items newItem) throws JsonProcessingException  {
        return itemService.getItemByName(newItem ,"cateogry","natacion");
    }

}

