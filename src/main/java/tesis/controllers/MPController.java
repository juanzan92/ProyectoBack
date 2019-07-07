package tesis.controllers;

import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Card;
import com.mercadopago.resources.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tesis.services.impl.mercadopago.CardService;
import tesis.services.impl.mercadopago.UserServices;

import java.util.ArrayList;

@RestController
public class MPController {
    @Autowired
    UserServices userServices;
    @Autowired
    CardService cardService;

    @PostMapping("/mp/user/create_user")
    public String createUser() {
        return userServices.createUser();
    }

    @GetMapping("/mp/user/get_user")
    public Customer getUser() throws MPException {
        return userServices.getUser("449730233-vpQkKAveTRQgJV");
    }

    @GetMapping("/mp/card/get_user_cards")
    public ArrayList<Card> getUserCards() throws MPException {
        return cardService.getUserCards("449730233-vpQkKAveTRQgJV");
    }
}
