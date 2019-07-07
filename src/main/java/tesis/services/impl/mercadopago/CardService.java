package tesis.services.impl.mercadopago;


import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Card;
import com.mercadopago.resources.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CardService {

    public Card createCard(Customer customer) throws MPException {
        Card card = new Card();
        try {
            card.setToken("9b2d63e00d66a8c721607214cedaecda");
            card.setCustomerId(customer.getId());
            card.save();
        } catch (MPException e) {
            throw e;
        }

        return card;
    }

    public ArrayList<Card> getUserCards(String customerId) throws MPException {
        MercadoPago.SDK.configure("TEST-5912969040584293-092110-771d21ab7cc96c709fbcc464d05c409b-187271358");
        Customer customer = null;
        try {
            customer = Customer.findById(customerId);
        } catch (MPException e) {
            throw e;
        }

        return customer.getCards();
    }
}
