package tesis.services.mercadopago;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tesis.entities.builders.MPBackUrlsBuilder;
import tesis.entities.builders.MPItemBuilder;
import tesis.entities.builders.MPPayerBuilder;
import tesis.entities.builders.MPPreferenceBuilder;
import tesis.entities.dtos.item.Item;
import tesis.entities.dtos.mercadopago.Consumer;
import tesis.entities.dtos.mercadopago.PreferenceDTO;
import tesis.entities.dtos.mercadopago.Vendor;
import tesis.entities.marshallers.PreferenceMarshaller;
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
        Consumer consumer = preferenceDTO.getConsumer();
        Vendor vendor = userService.getVendor(preferenceDTO.getVendorName());
        Item item = itemService.getItem(preferenceDTO.getItemName());

        MercadoPago.SDK.setAccessToken(vendor.getAccessToken());

        Preference preference = MPPreferenceBuilder.buildPreference(preferenceDTO, item, consumer);

        return PreferenceMarshaller.buildUrlPreference(preference);
    }
}
