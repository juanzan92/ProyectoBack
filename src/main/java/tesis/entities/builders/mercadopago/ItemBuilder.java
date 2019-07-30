package tesis.entities.builders.mercadopago;

import com.mercadopago.resources.datastructures.preference.Item;
import tesis.entities.dtos.mercadopago.Preference;
import tesis.entities.enums.item.CategoryId;

public class ItemBuilder {

    public static Item buildItem(Preference preference, tesis.entities.dtos.item.Item dynamoItem) {
        return new Item().setId(preference.getItemName())
                .setTitle(dynamoItem.getTitle())
                .setQuantity(dynamoItem.getStock())
                .setCategoryId(CategoryId.ARS.toString())
                .setUnitPrice(dynamoItem.getInitialPrice());
    }
}
