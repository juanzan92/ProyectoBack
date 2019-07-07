package tesis.services.impl.mercadopago;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.datastructures.payment.Payer;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment createPayment() throws MPException {
        MercadoPago.SDK.configure("TEST-5912969040584293-092110-771d21ab7cc96c709fbcc464d05c409b-187271358");

        Payer payer = new Payer();
        payer.setType(Payer.type.customer);
        payer.setId("449730233-vpQkKAveTRQgJV");

        Payment payment = new Payment();
        try {

            payment.setTransactionAmount((float) 100);
            payment.setToken("9b2d63e00d66a8c721607214cedaecda");
            payment.setPayer(payer);

            payment.save();
        } catch (MPException e) {
            throw e;
        }
        return payment;
    }
}
