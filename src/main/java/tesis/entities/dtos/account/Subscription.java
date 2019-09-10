package tesis.entities.dtos.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadopago.resources.datastructures.merchantorder.MerchantOrderPayment;
import tesis.entities.dtos.mercadopago.Shipment;
import tesis.entities.enums.user.SubscriptionStatus;

import java.util.ArrayList;
import java.util.Date;

public class Subscription {

    @JsonProperty("date_created")
    private Date dateCreated;

    @JsonProperty("item_id")
    private String itemId;

    @JsonProperty("merchant_order_id")
    private String merchantOrderId;

    @JsonProperty("preference_id")
    private String preferenceId;

    @JsonProperty("paid_amount")
    private float paidAmount;

    @JsonProperty("payment")
    private ArrayList<MerchantOrderPayment> payment;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("refunded_amount")
    private float refundedAmount;

    @JsonProperty("shipments")
    private ArrayList<Shipment> shipments;

    @JsonProperty("subscription_id")
    private String subscriptionId;

    @JsonProperty("subscription_status")
    private SubscriptionStatus subscriptionStatus;

    @JsonProperty("total_amount")
    private float totalAmount;

    @JsonProperty("username")
    private String username;

    @JsonProperty("vendor_name")
    private String vendorName;

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public Subscription setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
        return this;
    }

    public SubscriptionStatus getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public Subscription setSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Subscription setUsername(String username) {
        this.username = username;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public Subscription setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getPreferenceId() {
        return preferenceId;
    }

    public Subscription setPreferenceId(String preferenceId) {
        this.preferenceId = preferenceId;
        return this;
    }

    public ArrayList<MerchantOrderPayment> getPayment() {
        return payment;
    }

    public Subscription setPayment(ArrayList<MerchantOrderPayment> payment) {
        this.payment = payment;
        return this;
    }

    public ArrayList<Shipment> getShipments() {
        return shipments;
    }

    public Subscription setShipments(ArrayList<Shipment> shipments) {
        this.shipments = shipments;
        return this;
    }

    public String getVendorName() {
        return vendorName;
    }

    public Subscription setVendorName(String vendorName) {
        this.vendorName = vendorName;
        return this;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Subscription setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public Subscription setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public float getPaidAmount() {
        return paidAmount;
    }

    public Subscription setPaidAmount(float paidAmount) {
        this.paidAmount = paidAmount;
        return this;
    }

    public float getRefundedAmount() {
        return refundedAmount;
    }

    public Subscription setRefundedAmount(float refundedAmount) {
        this.refundedAmount = refundedAmount;
        return this;
    }

    public String getItemId() {
        return itemId;
    }

    public Subscription setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }
}
