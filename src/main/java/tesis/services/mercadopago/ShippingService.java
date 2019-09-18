package tesis.services.mercadopago;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import tesis.entities.builders.dynamo.DynamoBuilder;
import tesis.entities.dtos.ForDynamo;
import tesis.entities.dtos.account.Subscription;
import tesis.entities.dtos.mercadopago.Shipment;
import tesis.services.RestClient;
import tesis.services.account.SubscriptionService;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.UUID;

@Service
public class ShippingService {

    @Autowired
    RestClient restClient;

    @Autowired
    SubscriptionService subscriptionService;

    String urlBase = "https://rtge19cj13.execute-api.us-east-1.amazonaws.com/prod/generic_ep";
    ForDynamo forDynamo = new ForDynamo("subscriptions", "subscription_id"); //TODO ver como filtrar por shipment_id y actualizar ese valor

    public String createShipment(@NotNull Shipment shipment) throws JsonProcessingException {
        return restClient.request(urlBase, DynamoBuilder.saveObject(shipment, forDynamo), HttpMethod.POST, String.class);
    }

    public String updateShipment(@NotNull String subscriptionId, @NotNull Shipment shipment) throws Exception {
        try {
            shipment.setShipmentId(UUID.randomUUID().toString())
                    .setLastModified(new Date()).setDateCreated(new Date());

            Subscription subscription = subscriptionService.getSubscription(DynamoBuilder.buildMap("subscription_id", subscriptionId));

            subscription.getShipments().add(shipment);

            return restClient.request(urlBase, DynamoBuilder.saveObject(subscription, forDynamo), HttpMethod.PUT, String.class);
        } catch (Exception e) {
            throw new Exception();
        }
    }

    public ArrayList<Shipment> getShipments(String subscriptionId) throws JsonProcessingException {
        Subscription subscription = subscriptionService.getSubscription(DynamoBuilder.buildMap("subscription_id", subscriptionId));

        subscription.getShipments().sort(Comparator.comparing(s -> s.getDateCreated()));

        return subscription.getShipments();
    }
}
