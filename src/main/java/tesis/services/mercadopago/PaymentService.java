package tesis.services.mercadopago;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mercadopago.exceptions.MPConfException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import tesis.services.RestClient;

@Service
public class PaymentService {
    @Autowired
    RestClient restClient;

    public String analizeNotification(String notificationType, Long id) throws MPConfException, JsonProcessingException {
        String url = "https://api.mercadopago.com/v1/" + notificationType + "/" + id + "?access_token=" + "TEST-5912969040584293-092110-771d21ab7cc96c709fbcc464d05c409b-187271358";

        return restClient.request(url, null, HttpMethod.GET, String.class);
    }
}
