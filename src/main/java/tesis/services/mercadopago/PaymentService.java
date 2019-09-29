package tesis.services.mercadopago;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import tesis.entities.builders.dynamo.DynamoBuilder;
import tesis.entities.builders.mercadopago.SubscriptionBuilder;
import tesis.entities.dtos.account.Subscription;
import tesis.entities.dtos.account.User;
import tesis.entities.dtos.mercadopago.MerchantOrder;
import tesis.entities.dtos.mercadopago.Vendor;
import tesis.entities.marshallers.mercadopago.SubscriptionMarshaller;
import tesis.services.RestClient;
import tesis.services.account.SubscriptionService;
import tesis.services.account.UserService;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Map;

@Service
public class PaymentService {
    @Autowired
    RestClient restClient;
    @Autowired
    SubscriptionService subscriptionService;
    @Autowired
    UserService userService;

    String appOwnerToken = "TEST-6597192979858931-082414-a77f17d601ed0de0e44bec1ee3f6e297-463910841";
    String accessToken = "?access_token=" + appOwnerToken;
    String mpLink = "https://api.mercadopago.com";

    @PostConstruct
    private void configureSDK() {
        try {
            MercadoPago.SDK.setAccessToken(appOwnerToken);
        } catch (MPException e) {
            e.printStackTrace();
        }
    }

    public Payment analizeNotification(String notificationType, Long id) throws JsonProcessingException {
        String url = mpLink + "/v1/" + notificationType + "/" + id + accessToken;
        Payment payment = restClient.request(url, HttpMethod.GET, Payment.class);

        return payment;
    }

    public Map createMerchantOrder(Long merchantOrderId, String preferenceId) throws IOException, MPException {
        try {
            String url = mpLink + "/merchant_orders/" + merchantOrderId + accessToken;

            MerchantOrder merchantOrder = restClient.request(url, HttpMethod.GET, MerchantOrder.class);

            com.mercadopago.resources.Preference preference = com.mercadopago.resources.Preference.findById(preferenceId); //TODO el email del payer debería salir del merchant order, pero últimamente viene null. Revisar luego

            if (merchantOrder.getCollector().getEmail() != null && preference.getPayer().getEmail() != null) {

                String vendorUser = userService.searchUser("email", merchantOrder.getCollector().getEmail()).getUsername();

                User consumerUser = userService.searchUser("email", preference.getPayer().getEmail());

                Subscription subscription = subscriptionService.createSubscription(SubscriptionBuilder.orderBuilder(merchantOrder, vendorUser, consumerUser));

                return SubscriptionMarshaller.buildSubscription(subscription);
            }

        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public void cancelPayment(String subscriptionId) throws JsonProcessingException, MPException {
        Subscription subscription = subscriptionService.getSubscription(DynamoBuilder.buildMap("subscription_id", subscriptionId));

        Vendor vendor = userService.getVendor(DynamoBuilder.buildMap("username", subscription.getVendorName()));

        MercadoPago.SDK.setAccessToken(vendor.getAccessToken());
        Payment payment = Payment.findById(subscription.getPayment().get(0).getId());
        payment.setStatus(Payment.Status.refunded);
        payment.save();
    }
}
