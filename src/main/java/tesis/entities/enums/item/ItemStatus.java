package tesis.entities.enums.item;

public enum ItemStatus {
    ACTIVE,     // Cuando podes comprar
    INACTIVE,   // For future reference
    PENDING,    // Cuando lo cargó el vendor y aún no se aprobó por los Admins
    CANCELLED,  //  No se lleó al 100%
    DELIVERING, // Cuando se cierra el lote, y empieza la compra y delivery.
    FINISHED    // cuando se entregaron / delivered el  100% de las subscriptions
}