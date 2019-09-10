package tesis.entities.dtos.mercadopago;


import com.fasterxml.jackson.annotation.JsonProperty;
import tesis.entities.enums.mercadopago.ShipmentStatus;

import java.util.Date;

public class Shipment {

    @JsonProperty("id")
    private Integer shipmentId = null;

    @JsonProperty("shipment_type")
    private String shipmentType = null;

    @JsonProperty("shipment_mode")
    private String shipmentMode = null;

    @JsonProperty("picking_type")
    private String pickingType = null;

    @JsonProperty("status")
    private ShipmentStatus status = null;

    @JsonProperty("substatus")
    private String substatus = null;

    @JsonProperty("items")
    private Object items = null;

    @JsonProperty("date_created")
    private Date dateCreated = null;

    @JsonProperty("last_modified")
    private Date lastModified = null;

    @JsonProperty("date_first_printed")
    private Date dateFirstPrinted = null;

    @JsonProperty("service_id")
    private String serviceId = null;

    @JsonProperty("sender_id")
    private Integer senderId = null;

    @JsonProperty("receiver_id")
    private Integer receiverId = null;

    @JsonProperty("receiver_address")
    private Address receiverAddress = null;

    public Shipment() {
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

    public ShipmentStatus getStatus() {
        return status;
    }

    public Shipment setStatus(ShipmentStatus status) {
        this.status = status;
        return this;
    }

    public String getSubstatus() {
        return this.substatus;
    }

    public Shipment setSubstatus(String subStatus) {
        this.substatus = subStatus;
        return this;
    }

    public Object getItems() {
        return this.items;
    }

    public Shipment setItems(Object items) {
        this.items = items;
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
