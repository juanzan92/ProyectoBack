package tesis.controllers.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.account.Subscription;
import tesis.services.account.SubscriptionService;

import java.util.Map;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    @Autowired
    SubscriptionService subscriptionService;

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

    @PostMapping()
    public String createSubscription(@RequestBody Subscription subscription) throws JsonProcessingException {
        return subscriptionService.createSubscription(subscription);
    }

    @PutMapping()
    public String updateSubscription(@RequestBody Subscription subscription) throws JsonProcessingException {
        return subscriptionService.updateSubscription(subscription);
    }

    @DeleteMapping()
    public String deleteSubscription(@RequestBody Map<String, String> param) throws JsonProcessingException {
        return subscriptionService.deleteSubscription(param);
    }

    @DeleteMapping("/cancel")
    public String cancelSubscription(@RequestBody Subscription subscription) throws JsonProcessingException {
        return subscriptionService.cancelSubscription(subscription);
    }
}
