package tesis.entities.builders.mercadopago;

import com.mercadopago.resources.datastructures.preference.AddressReceiver;
import com.mercadopago.resources.datastructures.preference.Shipments;
import tesis.entities.dtos.mercadopago.Consumer;

public class ShipmentBuilder {
    public static Shipments buildShipment(Consumer consumer) {
        AddressReceiver addressReceiver = new AddressReceiver();
        addressReceiver.AddressReceiver(consumer.getAddressCode().toString(), consumer.getAddressNumber(), consumer.getAddressName(), "", "");
        return new Shipments()
                .setMode(Shipments.ShipmentMode.me2)
                .setDimensions("30x30x30,500")
                .setReceiverAddress(addressReceiver);

        /*consumer.getAddressCode().toString(), consumer.getAddressNumber(), consumer.getAddressName(), "", "");*/
                                /*.setZipCode(consumer.getAddressCode().toString())
                                .setStreetName(consumer.getAddressName())
                                .setStreetNumber(consumer.getAddressNumber()));*/
    }
}
