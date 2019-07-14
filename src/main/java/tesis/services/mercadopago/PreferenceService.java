package tesis.services.mercadopago;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.*;
import org.springframework.stereotype.Service;
import tesis.entities.dtos.mercadopago.PreferenceDTO;
import tesis.entities.marshallers.PreferenceMarshaller;

import java.util.HashMap;

@Service
public class PreferenceService {

    public HashMap<String, String> createPreference(PreferenceDTO preferenceDTO) throws MPException {
        MercadoPago.SDK.setAccessToken("APP_USR-5912969040584293-070913-71e68e7c6673f0c983ef7efbfdddfc4b-450661168"); //acá debería ir el token del vendedor

        Preference preference = new Preference();

        Item item = new Item();
        item.setId(preferenceDTO.getItemId().toString())
                .setTitle("Durable Concrete Gloves")
                .setQuantity(1)
                .setCategoryId("ARS")
                .setUnitPrice((float) 1.2);

        Payer payer = new Payer();
        payer.setName("pepito")
                .setSurname("gomez")
                .setEmail("kathryne_schiller@hotmail.com")
                .setPhone(new Phone()
                        .setAreaCode("351")
                        .setNumber("3702304"))
                .setIdentification(new Identification().setType("DNI").
                        setNumber("38333123"))
                .setAddress(new Address().setStreetName("sol de mayo").
                        setZipCode("5000").
                        setStreetNumber(123));

        BackUrls backUrls = new BackUrls("localhost:8080/success",
                "localhost:8080/pending",
                "localhost:8080/failure");

        preference.appendItem(item);
        preference.setMarketplaceFee((float) 1.1);
        preference.setPayer(payer);
        preference.setBackUrls(backUrls);
        preference.save();

        return PreferenceMarshaller.buildUrlPreference(preference);
    }
}
