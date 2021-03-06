package tesis.entities.builders.mercadopago;

import com.mercadopago.resources.datastructures.preference.AddressReceiver;
import com.mercadopago.resources.datastructures.preference.Shipments;
import tesis.entities.dtos.item.Dimensions;
import tesis.entities.dtos.item.Item;
import tesis.entities.dtos.mercadopago.Address;
import tesis.entities.dtos.mercadopago.Shipment;
import tesis.entities.enums.mercadopago.PickingType;
import tesis.entities.enums.mercadopago.ShipmentStatus;
import tesis.entities.enums.mercadopago.ShipmentType;

import java.util.ArrayList;
import java.util.Date;

public class ShipmentBuilder {
    public static Shipments buildShipment(Address address, Item item) {
        AddressReceiver addressReceiver = new AddressReceiver();
        Dimensions dimensions = item.getDimensions();
        addressReceiver.AddressReceiver(address.getAddressCode().toString(), address.getAddressNumber(),
                address.getAddressName(), address.getFloor(), address.getApartment());

        return new Shipments()
                .setMode(Shipments.ShipmentMode.me2)
                .setDimensions(dimensions.getHeight() + "x" +
                        dimensions.getWidth() + "x" +
                        dimensions.getDepth() + "," +
                        dimensions.getWeight())
                .setReceiverAddress(addressReceiver);
    }

    public static ArrayList<Shipment> buildShipment() {
        ArrayList<Shipment> shipments = new ArrayList<>();
        shipments.add(new Shipment().setShipmentType(ShipmentType.MANUAL)
                .setShipmentMode(Shipments.ShipmentMode.me2)
                .setPickingType(PickingType.CARRIER_OFFICE)
                .setShipmentStatus(ShipmentStatus.PENDING)
                .setDateCreated(new Date())
                .setLastModified(new Date()));

        return shipments;
    }
}
