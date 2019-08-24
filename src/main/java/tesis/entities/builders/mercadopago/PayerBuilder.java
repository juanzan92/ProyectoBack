package tesis.entities.builders.mercadopago;

import com.mercadopago.resources.datastructures.preference.Address;
import com.mercadopago.resources.datastructures.preference.Identification;
import com.mercadopago.resources.datastructures.preference.Payer;
import com.mercadopago.resources.datastructures.preference.Phone;
import tesis.entities.dtos.mercadopago.Consumer;
import tesis.entities.enums.user.DocumentType;

public class PayerBuilder {

    public static Payer buildPayer(Consumer consumer) {
        return new Payer().setName(consumer.getFirstName())
                .setSurname(consumer.getGivenName())
                .setEmail(consumer.getEmail())
                .setPhone(buildPhone(consumer))
                .setIdentification(buildIdentification(consumer))
                .setAddress(buildAddress(consumer));
    }

    public static Phone buildPhone(Consumer consumer) {
        return new Phone()
                .setAreaCode(consumer.getPhone().toString().substring(0, 3))
                .setNumber(consumer.getPhone().toString().substring(3));
    }

    public static Identification buildIdentification(Consumer consumer) {
        return new Identification().setType(DocumentType.DNI.toString()).
                setNumber(consumer.getDni().toString());
    }

    public static Address buildAddress(Consumer consumer) {
        return new Address().setStreetName(consumer.getAddressName()).
                setZipCode(consumer.getAddressCode().toString()).
                setStreetNumber(consumer.getAddressNumber());
    }
}
