package tesis.entities.enums.mercadopago;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ShipmentType {
    @JsonProperty("manual")
    MANUAL;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
