package tesis.entities.dtos.mercadopago;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadopago.resources.datastructures.merchantorder.MerchantOrderPayment;
import com.mercadopago.resources.datastructures.merchantorder.Shipment;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Order {
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

    public String getPreferenceId() {
        return preferenceId;
    }

    public Order setPreferenceId(String preferenceId) {
        this.preferenceId = preferenceId;
        return this;
    }

    public ArrayList<MerchantOrderPayment> getPayment() {
        return payment;
    }

    public Order setPayment(ArrayList<MerchantOrderPayment> payment) {
        this.payment = payment;
        return this;
    }

    public ArrayList<Shipment> getShipments() {
        return shipments;
    }

    public Order setShipments(ArrayList<Shipment> shipments) {
        this.shipments = shipments;
        return this;
    }

    public String getVendorName() {
        return vendorName;
    }

    public Order setVendorName(String vendorName) {
        this.vendorName = vendorName;
        return this;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Order setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public Order setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public float getPaidAmount() {
        return paidAmount;
    }

    public Order setPaidAmount(float paidAmount) {
        this.paidAmount = paidAmount;
        return this;
    }

    public float getRefundedAmount() {
        return refundedAmount;
    }

    public Order setRefundedAmount(float refundedAmount) {
        this.refundedAmount = refundedAmount;
        return this;
    }

    public String getItemId() {
        return itemId;
    }

    public Order setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }
}
