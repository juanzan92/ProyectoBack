package tesis.services.mercadopago;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tesis.entities.builders.dynamo.DynamoBuilder;
import tesis.entities.builders.mercadopago.PreferenceBuilder;
import tesis.entities.dtos.item.Item;
import tesis.entities.dtos.mercadopago.Preference;
import tesis.entities.dtos.mercadopago.Vendor;
import tesis.entities.marshallers.mercadopago.PreferenceMarshaller;
import tesis.services.account.UserService;
import tesis.services.item.ItemService;

import java.util.HashMap;

@Service
public class PreferenceService {
    @Autowired
    UserService userService;

    @Autowired
    ItemService itemService;

    public HashMap<String, String> createPreference(Preference preferenceDTO) throws MPException, JsonProcessingException {
        try {

            Item item = itemService.getItem(DynamoBuilder.buildMap("item_id", preferenceDTO.getItemId()));
            Vendor vendor = userService.getVendor(DynamoBuilder.buildMap("username", item.getVendorUsername()));

            MercadoPago.SDK.setAccessToken(vendor.getAccessToken());

            com.mercadopago.resources.Preference preference = PreferenceBuilder.buildPreference(preferenceDTO, item, preferenceDTO.getConsumer());

            return PreferenceMarshaller.buildUrlPreference(preference);
        } catch (Exception e) {
            throw e;
        }
    }
}
