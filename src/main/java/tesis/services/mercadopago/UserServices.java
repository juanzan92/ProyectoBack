package tesis.services.mercadopago;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mercadopago.MercadoPago;
import com.mercadopago.core.MPResourceArray;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import tesis.entities.dtos.mercadopago.Vendor;
import tesis.services.RestClient;
import tesis.services.account.UserService;

import java.util.HashMap;

@Service
public class UserServices {
    @Autowired
    CardService cardService;
    @Autowired
    RestClient restClient;
    @Autowired
    UserService userService;

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

    public MPResourceArray searchCustomer(String email) throws MPException {
        MercadoPago.SDK.configure("TEST-5912969040584293-092110-771d21ab7cc96c709fbcc464d05c409b-187271358");
        MPResourceArray customers = null;

        try {
            HashMap<String, String> filters = new HashMap<>();
            filters.put("email", email);

            customers = Customer.search(filters, false);

        } catch (MPException e) {
            throw e;
        }
        return customers;
    }

    public String createMarketplaceAuth(String authCode, String userId) throws JsonProcessingException {
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("client_id", "5912969040584293");
        requestBody.add("client_secret", "7f0EFL7Ers6j3CU9bjlFBurNErUufQZv");
        requestBody.add("grant_type", "authorization_code");
        requestBody.add("code", authCode);
        requestBody.add("redirect_uri", "http://localhost:3000/splash?user_id=" + userId);

        Vendor vendor = restClient.formRequest("https://api.mercadopago.com/oauth/token", requestBody, Vendor.class);
        userService.createVendorUser(vendor);
        return "";
    }
}
