package tesis.entities.enums.mercadopago;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum PickingType {
    @JsonProperty("carrier_office")
    CARRIER_OFFICE;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
