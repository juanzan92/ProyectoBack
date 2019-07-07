package tesis.controllers;

import com.mercadopago.core.MPResourceArray;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Card;
import com.mercadopago.resources.Customer;
import com.mercadopago.resources.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tesis.services.impl.mercadopago.CardService;
import tesis.services.impl.mercadopago.PaymentService;
import tesis.services.impl.mercadopago.UserServices;

import java.util.ArrayList;

@RestController
public class MPController {
    @Autowired
    UserServices userServices;
    @Autowired
    CardService cardService;
    @Autowired
    PaymentService paymentService;

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

    @PostMapping("/mp/payments/create_payment")
    public Payment createPayment() throws MPException {
        return paymentService.createPayment();
    }

    @PostMapping("/mp/cards/create_card")
    public Card createCard() throws MPException {
        return cardService.createCard("449730233-vpQkKAveTRQgJV");
    }


}
