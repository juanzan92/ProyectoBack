package tesis.entities.builders.mercadopago;

import com.mercadopago.resources.datastructures.preference.Identification;
import com.mercadopago.resources.datastructures.preference.Payer;
import com.mercadopago.resources.datastructures.preference.Phone;
import tesis.entities.dtos.account.User;
import tesis.entities.dtos.mercadopago.Address;
import tesis.entities.enums.user.DocumentType;

public class PayerBuilder {

    public static Payer buildPayer(User consumer) {
        return new Payer().setName(consumer.getFirstName())
                .setSurname(consumer.getLastName())
                .setEmail(consumer.getEmail())
                .setPhone(buildPhone(consumer))
                .setIdentification(buildIdentification(consumer))
                .setAddress(buildAddress(consumer.getAddress()));
    }

    public static Phone buildPhone(User consumer) {
        return new Phone()
                .setAreaCode(consumer.getPhone().toString().substring(0, 3))
                .setNumber(consumer.getPhone().toString().substring(3));
    }

    public static Identification buildIdentification(User consumer) {
        return new Identification().setType(DocumentType.DNI.toString()).
                setNumber(consumer.getDni().toString());
    }

    public static com.mercadopago.resources.datastructures.preference.Address buildAddress(Address address) {
        return new com.mercadopago.resources.datastructures.preference.Address().setStreetName(address.getAddressName()).
                setZipCode(address.getAddressCode().toString()).
                setStreetNumber(address.getAddressNumber());
    }
}
