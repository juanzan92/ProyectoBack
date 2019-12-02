package tesis.services.mercadopago;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tesis.entities.builders.dynamo.DynamoBuilder;
import tesis.entities.builders.mercadopago.PreferenceBuilder;
import tesis.entities.dtos.account.User;
import tesis.entities.dtos.item.Item;
import tesis.entities.dtos.mercadopago.Preference;
import tesis.entities.dtos.mercadopago.Vendor;
import tesis.entities.enums.item.ItemStatus;
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

    private String username = "username";

    public HashMap<String, String> createPreference(Preference preference) throws MPException, JsonProcessingException {
        try {

            Item item = itemService.getItem(DynamoBuilder.buildMap("item_id", preference.getItemId()));
            if (item == null) {
                throw new IllegalArgumentException("Item not found - Transaction Canceled");
            }
            if (item.getStatus() != ItemStatus.ACTIVE) {
                throw new IllegalArgumentException("Item is NOT ACTIVE - Transaction Canceled");
            }
            if (item.getStock() < preference.getQuantity()) {
                throw new IllegalArgumentException("Not Enough stock to Subscribe - Transaction Canceled");
            }

            Vendor vendor = userService.getVendor(DynamoBuilder.buildMap(username, item.getVendorUsername()));
            Vendor vendorJak = userService.getVendor(DynamoBuilder.buildMap(username, "jak"));
            MercadoPago.SDK.setAccessToken(vendorJak.getAccessToken());

            User consumer = userService.getUser(DynamoBuilder.buildMap(username, preference.getConsumerUsername()));

            com.mercadopago.resources.Preference mpPreference = PreferenceBuilder.buildPreference(preference, item, consumer);

            return PreferenceMarshaller.buildUrlPreference(mpPreference);
        } catch (Exception e) {
            throw e;
        }
    }
}
