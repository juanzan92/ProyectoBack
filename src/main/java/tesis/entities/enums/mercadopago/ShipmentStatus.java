package tesis.entities.enums.mercadopago;

public enum ShipmentStatus {
    PENDING,
    IN_PROGRESS,
    DELIVERED;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
