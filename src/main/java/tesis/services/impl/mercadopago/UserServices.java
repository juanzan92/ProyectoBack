package tesis.services.impl.mercadopago;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    @Autowired
    CardService cardService;

    public String createUser() {
        try {
            MercadoPago.SDK.configure("TEST-5912969040584293-092110-771d21ab7cc96c709fbcc464d05c409b-187271358");
            Customer customer = createUser("todo_guion_bajo@yahoo.com");
            cardService.createCard(customer);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Customer createUser(String email) {
        Customer customer = new Customer();
        try {
            customer.setEmail(email);
            customer.save();
        } catch (MPException e) {
            e.printStackTrace();
        }

        return customer;
    }

    public Customer getUser(String customerId) throws MPException {
        MercadoPago.SDK.configure("TEST-5912969040584293-092110-771d21ab7cc96c709fbcc464d05c409b-187271358");
        Customer customer = null;
        try {
            customer = Customer.findById(customerId);
        } catch (MPException e) {
            throw e;
        }
        return customer;
    }
}
