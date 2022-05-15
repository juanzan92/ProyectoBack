package tesis.entities.dtos.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadopago.resources.datastructures.merchantorder.MerchantOrderPayment;
import lombok.Getter;
import lombok.Setter;
import tesis.entities.dtos.mercadopago.Payment;
import tesis.entities.dtos.mercadopago.Shipment;
import tesis.entities.enums.user.SubscriptionStatus;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
public class Subscription {

    @JsonProperty("category")
    String category;

    @JsonProperty("date_created")
    Date dateCreated;

    @JsonProperty("item_id")
    String itemId;

    @JsonProperty("merchant_order_id")
    private String merchantOrderId;

    @JsonProperty("preference_id")
    String preferenceId;

    @JsonProperty("paid_amount")
    float paidAmount;

    @JsonProperty("payment")
    ArrayList<Payment> payment;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("refunded_amount")
    float refundedAmount;

    @JsonProperty("shipments")
    ArrayList<Shipment> shipments;

    @JsonProperty("subscription_id")
    private String subscriptionId;

    @JsonProperty("subscription_status")
    SubscriptionStatus subscriptionStatus;

    @JsonProperty("total_amount")
    float totalAmount;

    @JsonProperty("username")
    private String username;

    @JsonProperty("vendor_name")
    String vendorName;

    @JsonProperty("item_title")
    String itemTitle;

    @JsonProperty("shipping_cost")
    float shippingCost;

    @JsonProperty("transaction_amount")
    float transactionAmount;

    public float getTransactionAmount() {
        return transactionAmount;
    }

    public Subscription setTransactionAmount(float transactionAmount) {
        this.transactionAmount = transactionAmount;
        return this;
    }

    public float getShippingCost() {
        return shippingCost;
    }

    public Subscription setShippingCost(float shippingCost) {
        this.shippingCost = shippingCost;
        return this;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public Subscription setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
        return this;
    }

    public Subscription setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
        return this;
    }

    public Subscription setSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
        return this;
    }

    public Subscription setUsername(String username) {
        this.username = username;
        return this;
    }

    public Subscription setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public Subscription setPreferenceId(String preferenceId) {
        this.preferenceId = preferenceId;
        return this;
    }

    public Subscription setPayment(ArrayList<Payment> payment) {
        this.payment = payment;
        return this;
    }

    public Subscription setShipments(ArrayList<Shipment> shipments) {
        this.shipments = shipments;
        return this;
    }

    public Subscription setVendorName(String vendorName) {
        this.vendorName = vendorName;
        return this;
    }

    public Subscription setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public Subscription setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public Subscription setPaidAmount(float paidAmount) {
        this.paidAmount = paidAmount;
        return this;
    }

    public Subscription setRefundedAmount(float refundedAmount) {
        this.refundedAmount = refundedAmount;
        return this;
    }

    public Subscription setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }
}
