package tesis.entities.builders.mercadopago;

import com.mercadopago.resources.datastructures.preference.Item;
import tesis.entities.dtos.mercadopago.Preference;
import tesis.entities.enums.item.CategoryId;

public class ItemBuilder {

    public static Item buildItem(tesis.entities.dtos.item.Item dynamoItem, int quantity) {
        return new Item().setId(dynamoItem.getItemId())
                .setTitle(dynamoItem.getTitle())
                .setQuantity(quantity)
                .setCategoryId(CategoryId.ARS.toString())
                .setUnitPrice(dynamoItem.getInitialPrice());
    }
}
