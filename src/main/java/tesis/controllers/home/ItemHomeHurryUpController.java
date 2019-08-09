package tesis.controllers.home;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.home.ItemHomeHurryUp;
import tesis.services.home.ItemHomeHurryUpService;

import java.util.Map;

@RestController
@RequestMapping("/catalog/items/home/hurry_up")
public class ItemHomeHurryUpController {
    @Autowired
    ItemHomeHurryUpService itemHomeHurryUpService;

    @PostMapping()
    public String createItemHomeHurryUp(@RequestBody ItemHomeHurryUp itemHomeHurryUp) throws JsonProcessingException {
        return itemHomeHurryUpService.createItemHomeHurryUp(itemHomeHurryUp);
    }

    @GetMapping("/search")
    public ItemHomeHurryUp[] searchItemsHomeCarrouselMain(@RequestBody Map<String, String> param) throws JsonProcessingException {
        return itemHomeHurryUpService.searchItemsHomeHurryUp(param);
    }
}
