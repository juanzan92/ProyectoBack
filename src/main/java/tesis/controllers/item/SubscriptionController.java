package tesis.controllers.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mercadopago.exceptions.MPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.ForReportsSimpleRadar;
import tesis.entities.dtos.account.Subscription;
import tesis.services.account.SubscriptionService;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    @Autowired
    SubscriptionService subscriptionService;

    @PostMapping()
    public Map createSubscription(@RequestParam("merchant_order_id") Long merchantOrderId, @RequestParam("preference_id") String preferenceId) throws IOException, MPException {
        return subscriptionService.createSubscription(merchantOrderId, preferenceId);
    }

    @DeleteMapping()
    public String cancelSubscription(@RequestParam("subscription_id") String subscriptionId) throws JsonProcessingException, MPException {
        return subscriptionService.cancelSubscription(subscriptionId);
    }

    @GetMapping()
    public Subscription getSubscription(@RequestParam Map<String, String> subscription_id) throws JsonProcessingException {
        return subscriptionService.getSubscription(subscription_id);
    }

    @GetMapping("/search")
    public Subscription[] searchSubscription(@RequestParam Map<String, String> param) throws JsonProcessingException {
        return subscriptionService.searchSubscription(param);
    }

    @GetMapping("/get_all")
    public Subscription[] getAllSubscription() throws JsonProcessingException {
        return subscriptionService.getAllSubscription();
    }

    @PutMapping()
    public String updateSubscription(@RequestBody Subscription subscription) throws JsonProcessingException {
        return subscriptionService.updateSubscription(subscription);
    }
}
