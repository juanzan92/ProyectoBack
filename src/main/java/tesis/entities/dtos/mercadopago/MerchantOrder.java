package tesis.entities.dtos.mercadopago;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadopago.resources.datastructures.merchantorder.Collector;
import com.mercadopago.resources.datastructures.merchantorder.Item;
import com.mercadopago.resources.datastructures.merchantorder.MerchantOrderPayment;
import com.mercadopago.resources.datastructures.merchantorder.Payer;

import java.util.ArrayList;
import java.util.Date;

public class MerchantOrder {
    @JsonProperty("id")
    private String id;

    @JsonProperty("preference_id")
    private String preferenceId;

    @JsonProperty("date_created")
    private Date dateCreated;

    @JsonProperty("last_update")
    private Date lastUpdate;

    @JsonProperty("application_id")
    private String applicationId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("site_id")
    private String siteId;

    @JsonProperty("total_amount")
    private Float totalAmount;

    @JsonProperty("payer")
    private Payer payer;

    @JsonProperty("collector")
    private Collector collector;

    @JsonProperty("sponsor_id")
    private Integer sponsorId;

    @JsonProperty("payments")
    private ArrayList<Payment> payments;

    @JsonProperty("paid_amount")
    private Float paidAmount;

    @JsonProperty("refunded_amount")
    private Float refundedAmount;

    @JsonProperty("shipping_cost")
    private Float shippingCost;

    @JsonProperty("cancelled")
    private Boolean cancelled;

    @JsonProperty("items")
    private ArrayList<Item> items;

    @JsonProperty("shipments")
    private ArrayList<Shipment> shipments;

    public String getId() {
        return id;
    }

    public MerchantOrder setId(String id) {
        this.id = id;
        return this;
    }

    public String getPreferenceId() {
        return preferenceId;
    }

    public MerchantOrder setPreferenceId(String preferenceId) {
        this.preferenceId = preferenceId;
        return this;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public MerchantOrder setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public MerchantOrder setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public MerchantOrder setApplicationId(String applicationId) {
        this.applicationId = applicationId;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public MerchantOrder setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getSiteId() {
        return siteId;
    }

    public MerchantOrder setSiteId(String siteId) {
        this.siteId = siteId;
        return this;
    }

    public Payer getPayer() {
        return payer;
    }

    public MerchantOrder setPayer(Payer payer) {
        this.payer = payer;
        return this;
    }

    public Collector getCollector() {
        return collector;
    }

    public MerchantOrder setCollector(Collector collector) {
        this.collector = collector;
        return this;
    }

    public Integer getSponsorId() {
        return sponsorId;
    }

    public MerchantOrder setSponsorId(Integer sponsorId) {
        this.sponsorId = sponsorId;
        return this;
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public MerchantOrder setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
        return this;
    }

    public Float getPaidAmount() {
        return paidAmount;
    }

    public MerchantOrder setPaidAmount(Float paidAmount) {
        this.paidAmount = paidAmount;
        return this;
    }

    public Float getRefundedAmount() {
        return refundedAmount;
    }

    public MerchantOrder setRefundedAmount(Float refundedAmount) {
        this.refundedAmount = refundedAmount;
        return this;
    }

    public Float getShippingCost() {
        return shippingCost;
    }

    public MerchantOrder setShippingCost(Float shippingCost) {
        this.shippingCost = shippingCost;
        return this;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public MerchantOrder setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
        return this;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public MerchantOrder setItems(ArrayList<Item> items) {
        this.items = items;
        return this;
    }

    public ArrayList<Shipment> getShipments() {
        return shipments;
    }

    public MerchantOrder setShipments(ArrayList<Shipment> shipments) {
        this.shipments = shipments;
        return this;
    }


    public Float getTotalAmount() {
        return totalAmount;
    }

    public MerchantOrder setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }
}
