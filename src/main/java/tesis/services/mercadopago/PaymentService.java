package tesis.services.mercadopago;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mercadopago.resources.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import tesis.entities.builders.mercadopago.OrderBuilder;
import tesis.entities.dtos.mercadopago.MerchantOrder;
import tesis.entities.dtos.mercadopago.Order;
import tesis.services.RestClient;

import java.io.IOException;

@Service
public class PaymentService {
    @Autowired
    RestClient restClient;

    public Payment analizeNotification(String notificationType, Long id) throws JsonProcessingException {

        String url = "https://api.mercadopago.com/v1/" + notificationType + "/" + id + "?access_token=" + "TEST-6597192979858931-082414-a77f17d601ed0de0e44bec1ee3f6e297-463910841";

        Payment payment = restClient.request(url, HttpMethod.GET, Payment.class);

        return payment;
    }


    public void createMerchantOrder(Long merchantOrderId) throws IOException {
        String url = "https://api.mercadopago.com/merchant_orders/" + merchantOrderId + "?access_token=TEST-6597192979858931-082414-a77f17d601ed0de0e44bec1ee3f6e297-463910841";
        MerchantOrder merchantOrder = restClient.request(url, HttpMethod.GET, MerchantOrder.class);
        Order order = OrderBuilder.orderBuilder(merchantOrder);
    }
}
