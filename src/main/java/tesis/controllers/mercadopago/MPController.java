package tesis.controllers.mercadopago;

import com.mercadopago.core.MPResourceArray;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Card;
import com.mercadopago.resources.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.mercadopago.PreferenceDTO;
import tesis.services.mercadopago.CardService;
import tesis.services.mercadopago.PreferenceService;
import tesis.services.mercadopago.UserServices;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class MPController {
    @Autowired
    UserServices userServices;
    @Autowired
    CardService cardService;
    @Autowired
    PreferenceService preferenceService;

    @PostMapping("/mp/users/create_user")
    public String createUser() {
        return userServices.createUser();
    }

    @GetMapping("/mp/users/get_user")
    public Customer getUser() throws MPException {
        return userServices.getUser("449730233-vpQkKAveTRQgJV");
    }

    @GetMapping("/mp/users/search_user")
    public MPResourceArray searchUser() throws MPException {
        return userServices.searchCustomer("todo_guion_bajo@yahoo.com");
    }

    @GetMapping("/mp/cards/get_user_cards")
    public ArrayList<Card> getUserCards() throws MPException {
        return cardService.getUserCards("449730233-vpQkKAveTRQgJV");
    }

    @PostMapping("/mp/cards/create_card")
    public Card createCard() throws MPException {
        return cardService.createCard("449730233-vpQkKAveTRQgJV");
    }

    @PostMapping("/mp/users/marketplace_auth")
    public String createMarketplaceAuth(@RequestParam String code) {
        return userServices.createMarketplaceAuth(code);
    }

    @PostMapping("/mp/preferences/create")
    public HashMap<String, String> createPreference(@RequestBody PreferenceDTO preferenceDTO) throws MPException {
     return preferenceService.createPreference(preferenceDTO);
    }

}
