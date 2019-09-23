package tesis.controllers.mercadopago;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.mercadopago.Preference;
import tesis.services.mercadopago.PaymentService;
import tesis.services.mercadopago.PreferenceService;
import tesis.services.mercadopago.UserServices;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/mp")
public class MPController {
    @Autowired
    UserServices userServices;
    @Autowired
    PreferenceService preferenceService;
    @Autowired
    PaymentService paymentService;

    @PostMapping("/users/marketplace_auth")
    public String createMarketplaceAuth(@RequestParam Map<String, String> allParams) throws JsonProcessingException {
        return userServices.createMarketplaceAuth(allParams.get("code"), allParams.get("user_id"));
    }

    @PostMapping("/preferences")
    public HashMap<String, String> createPreference(@RequestBody Preference preference) throws MPException, JsonProcessingException {
        return preferenceService.createPreference(preference);
    }

    @PostMapping("/payments/notification")
    public Payment paymentNotification(@RequestParam String topic, @RequestParam Long id) throws JsonProcessingException {
        return paymentService.analizeNotification(topic, id);
    }

    @PostMapping("/merchant_order")
    public String merchantOrder(@RequestParam Long merchant_order_id) throws IOException {
        return paymentService.createMerchantOrder(merchant_order_id);
    }

    @DeleteMapping("/payments")
    public void cancelPayment(@RequestParam String subscriptionId) throws IOException, MPException {
        paymentService.cancelPayment(subscriptionId);
    }
}
