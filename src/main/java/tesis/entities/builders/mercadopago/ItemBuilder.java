package tesis.entities.builders.mercadopago;

import com.mercadopago.resources.datastructures.preference.Item;
import tesis.entities.enums.item.CategoryId;

public class ItemBuilder {

    public static Item buildItem(tesis.entities.dtos.item.Item dynamoItem, int quantity) {
        return new Item().setId(dynamoItem.getItemId())
                .setTitle(dynamoItem.getTitle())
                .setDescription("zapatillitas nike")
                .setQuantity(quantity)
                .setCurrencyId(CategoryId.ARS.toString())
                .setCategoryId(dynamoItem.getCategory())
                .setUnitPrice(dynamoItem.getInitialPrice());
    }
}
