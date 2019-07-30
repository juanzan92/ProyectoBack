package tesis.entities.builders.mercadopago;

import com.mercadopago.exceptions.MPException;
import tesis.entities.dtos.item.Item;
import tesis.entities.dtos.mercadopago.Consumer;
import tesis.entities.dtos.mercadopago.Preference;

public class PreferenceBuilder {

    public static com.mercadopago.resources.Preference buildPreference(Preference preference, Item item, Consumer consumer) throws MPException {
        return new com.mercadopago.resources.Preference().appendItem(ItemBuilder.buildItem(preference, item))
                .setMarketplaceFee((float) ((item.getInitialPrice()) * 0.2))
                .setPayer(PayerBuilder.buildPayer(consumer))
                .setBackUrls(BackUrlsBuilder.buildBackUrls())
                .setNotificationUrl("http://localhost:8080/mp/payments/notification")
                .save();
    }
}
