package tesis.entities.builders;

import com.mercadopago.resources.datastructures.preference.Item;
import tesis.entities.dtos.mercadopago.PreferenceDTO;
import tesis.entities.enums.item.CategoryId;

public class MPItemBuilder {

    public static Item buildItem(PreferenceDTO preferenceDTO, tesis.entities.dtos.item.Item dynamoItem) {
        Item item = new Item();

        item.setId(preferenceDTO.getItemName())
                .setTitle(dynamoItem.getTitle())
                .setQuantity(dynamoItem.getStock())
                .setCategoryId(CategoryId.ARS.toString())
                .setUnitPrice(dynamoItem.getInitialPrice());
        return item;
    }
}
