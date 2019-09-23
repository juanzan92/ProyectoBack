package tesis.entities.dtos.mercadopago;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Preference {
    @JsonProperty("item_id")
    private String itemId;

    @JsonProperty("consumer_username")
    String consumer_username;

    @JsonProperty("quantity")
    int quantity;

    public String getConsumerUsername() {
        return consumer_username;
    }

    public Preference setConsumerUsername(String consumer_username) {
        this.consumer_username = consumer_username;
        return this;
    }

    public String getItemId() {
        return itemId;
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
