package tesis.services.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import tesis.entities.builders.dynamo.DynamoBuilder;
import tesis.entities.builders.mercadopago.SubscriptionBuilder;
import tesis.entities.dtos.ForDynamo;
import tesis.entities.dtos.account.Subscription;
import tesis.entities.dtos.account.User;
import tesis.entities.dtos.item.Item;
import tesis.entities.dtos.mercadopago.MerchantOrder;
import tesis.entities.dtos.mercadopago.Vendor;
import tesis.entities.enums.item.ItemStatus;
import tesis.entities.enums.user.SubscriptionStatus;
import tesis.entities.marshallers.mercadopago.SubscriptionMarshaller;
import tesis.services.RestClient;
import tesis.services.item.CategoryService;
import tesis.services.item.ItemService;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class SubscriptionService {
    @Autowired
    RestClient restClient;

    @Autowired
    ItemService itemService;

    @Autowired
    UserService userService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    KvsVendorService kvsVendorService;

    String urlBase = "https://rtge19cj13.execute-api.us-east-1.amazonaws.com/prod/generic_ep";
    ForDynamo forDynamo = new ForDynamo("subscriptions", "subscription_id");

    String appOwnerToken = "TEST-7512170400736377-110521-6635401b642d70c2f62abee2d6aefdaf-486477479";//TODO no sabemos porque de repente el apponwertoken es el del vendedor, averiguar eso.
    String accessToken = "?access_token=" + appOwnerToken;
    String mpLink = "https://api.mercadopago.com";

    String email = "email";
    String itemId = "item_id";

    @PostConstruct
    private void configureSDK() {
        try {
            MercadoPago.SDK.setAccessToken(appOwnerToken);
        } catch (MPException e) {
            e.printStackTrace();
        }
    }

    public Subscription createSubscription(Subscription subscription) throws JsonProcessingException {
        Item item = itemService.getItem(DynamoBuilder.buildMap("item_id", subscription.getItemId()));
        item.setStock(item.getStock() - subscription.getQuantity());
        itemService.updateItem(item);
        subscription.setCategory(item.getCategory());
        kvsVendorService.updateKvs(item, subscription);
        return restClient.request(urlBase, DynamoBuilder.saveObject(subscription, forDynamo), HttpMethod.POST, Subscription.class);
    }

    public Map createSubscription(Long merchantOrderId, String preferenceId) throws IOException, MPException {
        try {
            String url = mpLink + "/merchant_orders/" + merchantOrderId + accessToken;

            MerchantOrder merchantOrder = restClient.request(url, HttpMethod.GET, MerchantOrder.class);

            com.mercadopago.resources.Preference preference = com.mercadopago.resources.Preference.findById(preferenceId); //TODO el email del payer debería salir del merchant order, pero últimamente viene null. Revisar luego

            if (merchantOrder.getCollector().getEmail() != null && preference.getPayer().getEmail() != null) {

                String vendorUser = userService.searchUser(email, merchantOrder.getCollector().getEmail()).getUsername();

                User consumerUser = userService.searchUser(email, preference.getPayer().getEmail());

                Subscription subscription = SubscriptionBuilder.orderBuilder(merchantOrder, vendorUser, consumerUser);

                Item item = itemService.getItem(DynamoBuilder.buildMap(itemId, subscription.getItemId()));

                int newItemQuantity = item.getStock() - subscription.getQuantity();

                if (newItemQuantity == 0) {
                    item.setStatus(ItemStatus.FINISHED);
                    subscription.setSubscriptionStatus(SubscriptionStatus.DELIVERING);
                    HashMap<String, String> map = DynamoBuilder.buildMap("item_id", item.getItemId());
                    map.put("index_name", "item_id");
                    map.put("search_pattern", item.getItemId());
                    Subscription[] subscriptions = searchSubscription(map);

                    for (Subscription subscriptionTmp : subscriptions) {
                        if (subscriptionTmp.getSubscriptionStatus() == SubscriptionStatus.IN_PROGRESS) {
                            //cancelSubscription(subscription2.getSubscriptionId());
                            subscriptionTmp.setSubscriptionStatus(SubscriptionStatus.DELIVERING);
                            updateSubscription(subscriptionTmp);
                        }
                    }
                }

                itemService.updateItem(item);

                return SubscriptionMarshaller.buildSubscription(createSubscription(subscription));
            }

        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public String cancelSubscription(String subscriptionId) throws JsonProcessingException, MPException {
        try {

            Subscription subscription = getSubscription(DynamoBuilder.buildMap("subscription_id", subscriptionId));

            if (subscription.getSubscriptionStatus() != SubscriptionStatus.IN_PROGRESS) {
                return subscription.toString();
            }

            Vendor vendor = userService.getVendor(DynamoBuilder.buildMap("username", subscription.getVendorName()));

            MercadoPago.SDK.setAccessToken(vendor.getAccessToken());

            Payment payment = Payment.findById(subscription.getPayment().get(0).getId().toString());
            payment.refund();

            Item item = itemService.getItem(DynamoBuilder.buildMap(itemId, subscription.getItemId()));
            item.setStock(item.getStock() + subscription.getQuantity());

            if (item.getStatus() == ItemStatus.FINISHED) item.setStatus(ItemStatus.ACTIVE);

            itemService.updateItem(item);

            subscription.setSubscriptionStatus(SubscriptionStatus.CANCELLED);

            return updateSubscription(subscription);
        } catch (Exception e) {
            throw e;
        }
    }

    public Subscription getSubscription(Map<String, String> param) throws JsonProcessingException {
        return restClient.request(DynamoBuilder.getObject(param, forDynamo, urlBase), HttpMethod.GET, Subscription.class);
    }

    public Subscription[] getAllSubscription() throws JsonProcessingException {
        return restClient.request(DynamoBuilder.getAllObject(forDynamo, urlBase + "/get_all"), HttpMethod.GET, Subscription[].class);
    }

    public Subscription[] searchSubscription(Map<String, String> param) throws JsonProcessingException {
        return restClient.request(DynamoBuilder.searchObjects(param, forDynamo, urlBase + "/index_search"), HttpMethod.GET, Subscription[].class);
    }

    public Subscription[] searchSubscription(ForDynamo forDynamo) throws JsonProcessingException {
        return restClient.request(DynamoBuilder.searchObjects(forDynamo, urlBase + "/index_search"), HttpMethod.GET, Subscription[].class);
    }

    public String updateSubscription(Subscription subscription) throws JsonProcessingException {
        return restClient.request(urlBase, DynamoBuilder.saveObject(subscription, forDynamo), HttpMethod.PUT, String.class);
    }

    public String deleteSubscription(Map<String, String> param) throws JsonProcessingException {
        return restClient.request(urlBase, DynamoBuilder.getObject(param, forDynamo), HttpMethod.DELETE, String.class);
    }

    public Payment analizeNotification(String notificationType, Long id) throws JsonProcessingException {
        String url = mpLink + "/v1/" + notificationType + "/" + id + accessToken;
        Payment payment = restClient.request(url, HttpMethod.GET, Payment.class);
        return payment;
    }
}
