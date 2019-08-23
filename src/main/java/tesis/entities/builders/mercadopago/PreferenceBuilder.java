package tesis.entities.builders.mercadopago;

import com.mercadopago.exceptions.MPException;
import tesis.entities.dtos.item.Item;
import tesis.entities.dtos.mercadopago.Consumer;
import tesis.entities.dtos.mercadopago.Preference;

public class PreferenceBuilder {

    public static com.mercadopago.resources.Preference buildPreference(Preference preference, Item item, Consumer consumer) throws MPException {
        return new com.mercadopago.resources.Preference().appendItem(ItemBuilder.buildItem(item, preference.getQuantity()))
                .setMarketplaceFee(sMarketFeeByPurchase(item.getInitialPrice()))
                .setPayer(PayerBuilder.buildPayer(consumer))
                .setExternalReference("prueba_12345")
                .setBackUrls(BackUrlsBuilder.buildBackUrls())
                /*.setNotificationUrl("https://localhost:8080/mp/payments/notification")*/
                .save();
    }

    public static float sMarketFeeByPurchase(float initialPrice) {
        return (float) (initialPrice * 0.2);
    }
}
