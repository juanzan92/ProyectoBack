package tesis.controllers.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.item.Subscription;
import tesis.services.item.SubscriptionService;

import java.util.Map;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    @Autowired
    SubscriptionService subscriptionService;

    @GetMapping()
    public Subscription getSubscription(@RequestBody Map<String, String> param) throws JsonProcessingException {
        return subscriptionService.getSubscription(param);
    }

    @GetMapping("/search")
    public Subscription[] searchSubscription(@RequestBody Map<String, String> param) throws JsonProcessingException {
        return subscriptionService.searchSubscription(param);
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

}
