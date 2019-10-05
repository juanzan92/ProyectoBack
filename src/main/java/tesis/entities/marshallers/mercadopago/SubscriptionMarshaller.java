package tesis.entities.marshallers.mercadopago;

import tesis.entities.dtos.account.Subscription;

import javax.validation.constraints.NotNull;
import java.util.HashMap;

public class SubscriptionMarshaller {
    public static HashMap<String, String> buildSubscription(@NotNull Subscription subscription) {

        HashMap<String, String> map = new HashMap<>();
        map.put("suscription_id", subscription.getSubscriptionId());
        return map;
    }
}