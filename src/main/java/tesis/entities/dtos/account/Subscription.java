package tesis.entities.dtos.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadopago.resources.datastructures.merchantorder.MerchantOrderPayment;
import com.mercadopago.resources.datastructures.merchantorder.Shipment;

import java.util.ArrayList;
import java.util.Date;

public class Subscription {

    @JsonProperty("username")
    private String username;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("preference_id")
    String preferenceId;

    @JsonProperty("payment")
    ArrayList<MerchantOrderPayment> payment;

    @JsonProperty("shipments")
    ArrayList<Shipment> shipments;

    @JsonProperty("vendor_name")
    String vendorName;

    @JsonProperty("date_created")
    Date dateCreated;

    @JsonProperty("total_amount")
    float totalAmount;

    @JsonProperty("paid_amount")
    float paidAmount;

    @JsonProperty("refunded_amount")
    float refundedAmount;

    @JsonProperty("item_id")
    String itemId;

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
