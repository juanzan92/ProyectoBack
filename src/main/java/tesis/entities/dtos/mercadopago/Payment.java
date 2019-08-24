package tesis.entities.dtos.mercadopago;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Payment {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("status")
    private String status;

    @JsonProperty("description")
    private String description;

    @JsonProperty("transaction_amount")
    private float transactionAmount;
}
