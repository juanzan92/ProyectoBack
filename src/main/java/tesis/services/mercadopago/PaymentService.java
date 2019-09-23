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
import tesis.services.RestClient;
import tesis.services.account.SubscriptionService;
import tesis.services.account.UserService;

import java.io.IOException;

@Service
public class PaymentService {
    @Autowired
    RestClient restClient;
    @Autowired
    SubscriptionService subscriptionService;
    @Autowired
    UserService userService;

    public Payment analizeNotification(String notificationType, Long id) throws JsonProcessingException {
        String url = "https://api.mercadopago.com/v1/" + notificationType + "/" + id + "?access_token=" + "TEST-6597192979858931-082414-a77f17d601ed0de0e44bec1ee3f6e297-463910841";
        Payment payment = restClient.request(url, HttpMethod.GET, Payment.class);

        return payment;
    }

    public String createMerchantOrder(Long merchantOrderId) throws IOException {
        String url = "https://api.mercadopago.com/merchant_orders/" + merchantOrderId + "?access_token=TEST-6597192979858931-082414-a77f17d601ed0de0e44bec1ee3f6e297-463910841";

        MerchantOrder merchantOrder = restClient.request(url, HttpMethod.GET, MerchantOrder.class);

        String vendorUser = userService.searchUser("email", merchantOrder.getCollector().getEmail()).getUsername();

        User consumerUser = userService.searchUser("email", merchantOrder.getPayer().getEmail());

        return subscriptionService.createSubscription(SubscriptionBuilder.orderBuilder(merchantOrder, vendorUser, consumerUser));
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
