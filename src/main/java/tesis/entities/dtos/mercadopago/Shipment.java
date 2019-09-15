package tesis.entities.dtos.mercadopago;

import com.fasterxml.jackson.annotation.JsonProperty;
import tesis.entities.dtos.item.Item;
import tesis.entities.enums.mercadopago.ShipmentStatus;

import java.util.Date;

public class Shipment {

    @JsonProperty("id")
    private Integer shipmentId;

    @JsonProperty("subscription_id")
    private String subscriptionId;

    @JsonProperty("shipment_type")
    private String shipmentType;

    @JsonProperty("shipment_mode")
    private String shipmentMode;

    @JsonProperty("picking_type")
    private String pickingType;

    @JsonProperty("shipment_status")
    private ShipmentStatus shipmentStatus;

    @JsonProperty("substatus")
    private String substatus;

    @JsonProperty("items_description")
    private Item[] items_description;

    @JsonProperty("date_created")
    private Date dateCreated;

    @JsonProperty("last_modified")
    private Date lastModified;

    @JsonProperty("date_first_printed")
    private Date dateFirstPrinted;

    @JsonProperty("service_id")
    private String serviceId;

    @JsonProperty("sender_id")
    private Integer senderId = null;

    @JsonProperty("receiver_id")
    private Integer receiverId = null;

    @JsonProperty("receiver_address")
    private Address receiverAddress = null;

    public Shipment() {
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public Shipment setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
        return this;
    }

    public Integer getShipmentId() {
        return shipmentId;
    }

    public Shipment setShipmentId(Integer shipmentId) {
        this.shipmentId = shipmentId;
        return this;
    }

    public String getShipmentType() {
        return this.shipmentType;
    }

    public Shipment setShipmentType(String shipmentType) {
        this.shipmentType = shipmentType;
        return this;
    }

    public String getShipmentMode() {
        return this.shipmentMode;
    }

    public Shipment setShipmentMode(String shipmentMode) {
        this.shipmentMode = shipmentMode;
        return this;
    }

    public String getPickingType() {
        return this.pickingType;
    }

    public Shipment setPickingType(String pickingType) {
        this.pickingType = pickingType;
        return this;
    }

    public ShipmentStatus getShipmentStatus() {
        return shipmentStatus;
    }

    public Shipment setShipmentStatus(ShipmentStatus shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
        return this;
    }

    public String getSubstatus() {
        return this.substatus;
    }

    public Shipment setSubstatus(String subStatus) {
        this.substatus = subStatus;
        return this;
    }

    public Item[] getItems_description() {
        return items_description;
    }

    public Shipment setItems_description(Item[] items_description) {
        this.items_description = items_description;
        return this;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public Shipment setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public Shipment setLastModified(Date lastModified) {
        this.lastModified = lastModified;
        return this;
    }

    public Date getDateFirstPrinted() {
        return this.dateFirstPrinted;
    }

    public Shipment setDateFirstPrinted(Date dateFirstPrinted) {
        this.dateFirstPrinted = dateFirstPrinted;
        return this;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public Shipment setServiceId(String serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    public Integer getSenderId() {
        return this.senderId;
    }

    public Shipment setSenderId(Integer senderId) {
        this.senderId = senderId;
        return this;
    }

    public Integer getReceiverId() {
        return this.receiverId;
    }

    public Shipment setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
        return this;
    }

    public Address getReceiverAddress() {
        return this.receiverAddress;
    }

    public Shipment setReceiverAddress(Address receiverAddress) {
        this.receiverAddress = receiverAddress;
        return this;
    }
}
