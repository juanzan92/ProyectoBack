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

    @JsonProperty("total_paid_amount")
    private float totalPaidAmount;

    @JsonProperty("shipping_cost")
    private float shippingCost;


    public Long getId() {
        return id;
    }

    public Payment setId(Long id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Payment setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Payment setDescription(String description) {
        this.description = description;
        return this;
    }

    public float getTransactionAmount() {
        return transactionAmount;
    }

    public Payment setTransactionAmount(float transactionAmount) {
        this.transactionAmount = transactionAmount;
        return this;
    }

    public float getTotalPaidAmount() {
        return totalPaidAmount;
    }

    public Payment setTotalPaidAmount(float totalPaidAmount) {
        this.totalPaidAmount = totalPaidAmount;
        return this;
    }

    public float getShippingCost() {
        return shippingCost;
    }

    public Payment setShippingCost(float shippingCost) {
        this.shippingCost = shippingCost;
        return this;
    }
}
