package tesis.entities.builders;

import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import tesis.entities.dtos.item.Item;
import tesis.entities.dtos.mercadopago.Consumer;
import tesis.entities.dtos.mercadopago.PreferenceDTO;

public class MPPreferenceBuilder {

    public static Preference buildPreference(PreferenceDTO preferenceDTO, Item item, Consumer consumer) throws MPException {

        Preference preference = new Preference();
        preference.appendItem(MPItemBuilder.buildItem(preferenceDTO, item));
        preference.setMarketplaceFee((float) ((item.getInitialPrice()) * 0.2));
        preference.setPayer(MPPayerBuilder.buildPayer(consumer));
        preference.setBackUrls(MPBackUrlsBuilder.buildBackUrls());
        preference.save();

        return preference;
    }
}
