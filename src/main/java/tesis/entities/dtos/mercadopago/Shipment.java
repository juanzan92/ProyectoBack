package tesis.entities.dtos.mercadopago;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadopago.resources.datastructures.preference.Shipments;
import tesis.entities.enums.mercadopago.PickingType;
import tesis.entities.enums.mercadopago.ShipmentStatus;
import tesis.entities.enums.mercadopago.ShipmentType;

import java.util.Date;

public class Shipment {

    @JsonProperty("id")
    private String shipmentId;

    @JsonProperty("shipment_type")
    private ShipmentType shipmentType;

    @JsonProperty("shipment_mode")
    private Shipments.ShipmentMode shipmentMode;

    @JsonProperty("picking_type")
    private PickingType pickingType;

    @JsonProperty("shipment_status")
    private ShipmentStatus shipmentStatus;

    @JsonProperty("substatus")
    private String substatus;

    @JsonProperty("date_created")
    private Date dateCreated;

    @JsonProperty("last_modified")
    private Date lastModified;

    @JsonProperty("service_id")
    private String serviceId;

    @JsonProperty("sender_id")
    private Integer senderId;

    @JsonProperty("receiver_id")
    private Integer receiverId;

    @JsonProperty("receiver_address")
    private Address receiverAddress;

    public Shipment() {
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public Shipment setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
        return this;
    }

    public ShipmentType getShipmentType() {
        return shipmentType;
    }

    public Shipment setShipmentType(ShipmentType shipmentType) {
        this.shipmentType = shipmentType;
        return this;
    }

    public Shipments.ShipmentMode getShipmentMode() {
        return shipmentMode;
    }

    public Shipment setShipmentMode(Shipments.ShipmentMode shipmentMode) {
        this.shipmentMode = shipmentMode;
        return this;
    }

    public PickingType getPickingType() {
        return pickingType;
    }

    public Shipment setPickingType(PickingType pickingType) {
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
