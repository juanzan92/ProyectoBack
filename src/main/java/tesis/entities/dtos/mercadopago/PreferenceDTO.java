package tesis.entities.dtos.mercadopago;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PreferenceDTO {
    @JsonProperty("item_name")
    private String itemName;

    @JsonProperty("vendor_name")
    private String vendorName;

    @JsonProperty("consumer_info")
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

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }
}
