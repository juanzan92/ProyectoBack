package tesis.services.mercadopago;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tesis.entities.builders.mercadopago.PreferenceBuilder;
import tesis.entities.dtos.item.Item;
import tesis.entities.dtos.mercadopago.PreferenceDTO;
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

    public HashMap<String, String> createPreference(PreferenceDTO preferenceDTO) throws MPException, JsonProcessingException {
        try {
            HashMap<String, String> hola = new HashMap<>();
            hola.put("item_id", preferenceDTO.getItemName());

            Item item = itemService.getItem(hola);
            Vendor vendor = userService.getVendor(item.getVendorName());

            MercadoPago.SDK.setAccessToken(vendor.getAccessToken());

            Preference preference = PreferenceBuilder.buildPreference(preferenceDTO, item, preferenceDTO.getConsumer());

            return PreferenceMarshaller.buildUrlPreference(preference);
        } catch (Exception e) {
            throw e;
        }
    }
}
