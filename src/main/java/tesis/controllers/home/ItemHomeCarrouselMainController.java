package tesis.controllers.home;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.home.ItemHomeCarrouselMain;
import tesis.services.home.ItemHomeCarrouselMainService;


import java.util.Map;

@RestController
@RequestMapping("/catalog/items/home/carrousel_main")
public class ItemHomeCarrouselMainController {
    @Autowired
    ItemHomeCarrouselMainService itemHomeService;

    @PostMapping()
    public String createItemHomeCarrouselMain(@RequestBody ItemHomeCarrouselMain itemHomeCarrouselMain) throws JsonProcessingException {
        return itemHomeService.createItemHomeCarrouselMain(itemHomeCarrouselMain);
    }

    @GetMapping("/search")
    public ItemHomeCarrouselMain[] searchItemsHomeCarrouselMain(@RequestBody Map<String, String> param) throws JsonProcessingException {
        return itemHomeService.searchItemsHomeCarrouselMain(param);
    }
}
