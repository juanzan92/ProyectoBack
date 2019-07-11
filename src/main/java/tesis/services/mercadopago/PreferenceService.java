package tesis.services.mercadopago;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.Item;
import com.mercadopago.resources.datastructures.preference.Payer;
import org.springframework.stereotype.Service;
import tesis.marshallers.PreferenceMarshaller;

import java.util.HashMap;

@Service
public class PreferenceService {

    public HashMap <String, String> createPreference() throws MPException {
        MercadoPago.SDK.setAccessToken("APP_USR-5912969040584293-070913-71e68e7c6673f0c983ef7efbfdddfc4b-450661168"); //acá debería ir el token del vendedor

        Preference preference = new Preference();

        Item item = new Item();
        item.setId("1234")
                .setTitle("Durable Concrete Gloves")
                .setQuantity(1)
                .setCategoryId("ARS")
                .setUnitPrice((float) 1.2);

        Payer payer = new Payer();
        payer.setEmail("kathryne_schiller@hotmail.com");

        BackUrls backUrls = new BackUrls("localhost:8080/success", "localhost:8080/pending", "localhost:8080/failure");

        preference.appendItem(item);
        preference.setMarketplaceFee((float) 1.1);
        preference.setPayer(payer);
        preference.setBackUrls(backUrls);
        preference.save();

        return PreferenceMarshaller.buildUrlPreference(preference);
    }
}
