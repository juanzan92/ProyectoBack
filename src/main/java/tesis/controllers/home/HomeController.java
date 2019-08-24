

package tesis.controllers.home;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.home.ItemCarrouselBottom;
import tesis.entities.dtos.home.ItemCarrouselMain;
import tesis.entities.dtos.home.ItemHurryUp;
import tesis.services.home.HomeService;

@RestController
@RequestMapping("/catalog/items/home")
public class HomeController {
    @Autowired
    HomeService homeService;


    @PostMapping("/carrousel_main")
    public String createItemHomeCarrouselMain(@RequestBody ItemCarrouselMain itemCarrouselMain) throws JsonProcessingException {
        return homeService.createItemHomeCarrouselMain(itemCarrouselMain);
    }

    @GetMapping("/carrousel_main/search")
    public ItemCarrouselMain[] searchItemsHomeCarrouselMain() throws JsonProcessingException {
        return homeService.searchItemsHomeCarrouselMain();
    }

    @PostMapping("/hurry_up")
    public String createItemHomeHurryUp(@RequestBody ItemHurryUp itemHurryUp) throws JsonProcessingException {
        return homeService.createItemHomeHurryUp(itemHurryUp);
    }

    @GetMapping("/hurry_up/search")
    public ItemHurryUp[] searchItemsHomeHurryUp() throws JsonProcessingException {
        return homeService.searchItemsHomeHurryUp();
    }

    @PostMapping("/carrousel_bottom")
    public String createItemHomeCarrouselBottom(@RequestBody ItemCarrouselBottom itemCarrouselBottom) throws JsonProcessingException {
        return homeService.createItemHomeCarrouselBottom(itemCarrouselBottom);
    }

    @GetMapping("/carrousel_bottom/search")
    public ItemCarrouselBottom[] searchItemsHomeCarrouselBottom() throws JsonProcessingException {
        return homeService.searchItemsHomeCarrouselBottom();
    }
}
