package tesis.controllers.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.item.ItemHomeCarrouselMain;
import tesis.services.item.ItemHomeService;


import java.util.Map;

@RestController
@RequestMapping("/catalog/items/home")
public class ItemHomeController {
    @Autowired
    ItemHomeService itemHomeService;

    @PostMapping("/carrousel_main")
    public String createItemHomeCarrouselMain(@RequestBody ItemHomeCarrouselMain itemHomeCarrouselMain) throws JsonProcessingException {
        return itemHomeService.createItemHomeCarrouselMain(itemHomeCarrouselMain);
    }

    @GetMapping("/carrousel_main/search")
    public ItemHomeCarrouselMain[] searchItemsHomeCarrouselMain(@RequestBody Map<String, String> param) throws JsonProcessingException {
        return itemHomeService.searchItemsHomeCarrouselMain(param);
    }
}
