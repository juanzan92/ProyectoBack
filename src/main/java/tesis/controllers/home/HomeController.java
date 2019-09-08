

package tesis.controllers.home;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.home.ItemCarrouselBottom;
import tesis.entities.dtos.home.ItemCarrouselMain;
import tesis.entities.dtos.home.ItemHurryUp;
import tesis.services.home.HomeService;

import java.util.Map;

@RestController
@RequestMapping("/catalog/items/home")
public class HomeController {
    @Autowired
    HomeService homeService;


    @PostMapping("/carrousel_main")
    public String createItemCarrouselMain(@RequestBody ItemCarrouselMain itemCarrouselMain) throws JsonProcessingException {
        return homeService.createItemCarrouselMain(itemCarrouselMain);
    }

    @GetMapping("/carrousel_main/search")
    public ItemCarrouselMain[] searchItemsCarrouselMain() throws JsonProcessingException {
        return homeService.searchItemsCarrouselMain();
    }

    @PutMapping("/carrousel_main")
    public String updateItemCarrouselMain(@RequestBody ItemCarrouselMain itemCarrouselMain) throws JsonProcessingException {
        return homeService.updateItemCarrouselMain(itemCarrouselMain);
    }

    @DeleteMapping("/carrousel_main")
    public String deleteItemCarrouselMain(@RequestBody Map<String, String> param) throws JsonProcessingException {
        return homeService.deleteItemCarrouselMain(param);
    }

    @PostMapping("/hurry_up")
    public String createItemHurryUp(@RequestBody ItemHurryUp itemHurryUp) throws JsonProcessingException {
        return homeService.createItemHurryUp(itemHurryUp);
    }

    @GetMapping("/hurry_up/search")
    public ItemHurryUp[] searchItemsHomeHurryUp() throws JsonProcessingException {
        return homeService.searchItemsHurryUp();
    }

    @PutMapping("/hurry_up")
    public String updateItemHurryUp(@RequestBody ItemHurryUp itemHurryUp) throws JsonProcessingException {
        return homeService.updateItemHurryUp(itemHurryUp);
    }

    @DeleteMapping("/hurry_up")
    public String deleteItemHurryUp(@RequestBody Map<String, String> param) throws JsonProcessingException {
        return homeService.deleteItemHurryUp(param);
    }

    @PostMapping("/carrousel_bottom")
    public String createItemCarrouselBottom(@RequestBody ItemCarrouselBottom itemCarrouselBottom) throws JsonProcessingException {
        return homeService.createItemCarrouselBottom(itemCarrouselBottom);
    }

    @GetMapping("/carrousel_bottom/search")
    public ItemCarrouselBottom[] searchItemsCarrouselBottom() throws JsonProcessingException {
        return homeService.searchItemsCarrouselBottom();
    }

    @PutMapping("/carrousel_bottom")
    public String updateItemCarrouselBottom(@RequestBody ItemCarrouselBottom itemCarrouselBottom) throws JsonProcessingException {
        return homeService.updateItemCarrouselBottom(itemCarrouselBottom);
    }

    @DeleteMapping("/carrousel_bottom")
    public String deleteItemCarrouselBottom(@RequestBody Map<String, String> param) throws JsonProcessingException {
        return homeService.deleteItemCarrouselBottom(param);
    }
}
