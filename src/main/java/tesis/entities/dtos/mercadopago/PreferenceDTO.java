package tesis.entities.dtos.mercadopago;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PreferenceDTO {
    @JsonProperty("item_name")
    private String itemName;

    @JsonProperty("consumer")
    Consumer consumer;

    public Consumer getConsumer() {
        return consumer;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

}
