package tesis.controllers.home;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.home.ItemHomeCarrouselBottom;
import tesis.services.home.ItemHomeCarrouselBottomService;

import java.util.Map;

@RestController
@RequestMapping("/catalog/items/home/carrousel_bottom")
public class ItemHomeCarrouselBottomController {
    @Autowired
    ItemHomeCarrouselBottomService itemHomeService;

    @PostMapping()
    public String createItemHomeCarrouselBottom(@RequestBody ItemHomeCarrouselBottom itemHomeCarrouselBottom) throws JsonProcessingException {
        return itemHomeService.createItemHomeCarrouselBottom(itemHomeCarrouselBottom);
    }

    @GetMapping("/search")
    public ItemHomeCarrouselBottom[] searchItemsHomeCarrouselBottom(@RequestBody Map<String, String> param) throws JsonProcessingException {
        return itemHomeService.searchItemsHomeCarrouselBottom(param);
    }
}
