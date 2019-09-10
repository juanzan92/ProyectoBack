package tesis.entities.enums.mercadopago;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ShipmentStatus {
    @JsonProperty("pending")
    PENDING,

    @JsonProperty("in_progress")
    IN_PROGRESS,

    @JsonProperty("delivered")
    DELIVERED;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
