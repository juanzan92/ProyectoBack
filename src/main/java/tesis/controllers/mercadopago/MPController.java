package tesis.controllers.mercadopago;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.mercadopago.Preference;
import tesis.services.account.SubscriptionService;
import tesis.services.mercadopago.PreferenceService;
import tesis.services.mercadopago.UserServices;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(allowedHeaders = "*", maxAge = 3600, allowCredentials = "true")
@RequestMapping("/mp")
public class MPController {
    @Autowired
    UserServices userServices;
    @Autowired
    PreferenceService preferenceService;
    @Autowired
    SubscriptionService subscriptionService;

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
        return subscriptionService.analizeNotification(topic, id);
    }
}
