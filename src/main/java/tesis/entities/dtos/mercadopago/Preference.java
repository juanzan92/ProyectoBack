package tesis.entities.dtos.mercadopago;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Preference {
    @JsonProperty("item_id")
    private String itemId;

    @JsonProperty("consumer")
    Consumer consumer;

    @JsonProperty("quantity")
    int quantity;

    public Consumer getConsumer() {
        return consumer;
    }

    public String getItemName() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

}
