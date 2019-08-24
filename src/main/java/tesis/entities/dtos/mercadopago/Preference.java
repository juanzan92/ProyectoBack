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

    public String getItemId() {
        return itemId;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

}
