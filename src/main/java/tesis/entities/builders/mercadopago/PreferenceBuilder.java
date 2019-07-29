package tesis.entities.builders.mercadopago;

import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import tesis.entities.dtos.item.Item;
import tesis.entities.dtos.mercadopago.Consumer;
import tesis.entities.dtos.mercadopago.PreferenceDTO;

public class PreferenceBuilder {

    public static Preference buildPreference(PreferenceDTO preferenceDTO, Item item, Consumer consumer) throws MPException {

        Preference preference = new Preference();
        preference.appendItem(ItemBuilder.buildItem(preferenceDTO, item));
        preference.setMarketplaceFee((float) ((item.getInitialPrice()) * 0.2));
        preference.setPayer(PayerBuilder.buildPayer(consumer));
        preference.setBackUrls(BackUrlsBuilder.buildBackUrls());
        preference.setNotificationUrl("http://localhost:8080/mp/payments/notification");
        preference.save();

        return preference;
    }
}
