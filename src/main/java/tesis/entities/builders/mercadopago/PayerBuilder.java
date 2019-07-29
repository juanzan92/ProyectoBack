package tesis.entities.builders.mercadopago;

import com.mercadopago.resources.datastructures.preference.Address;
import com.mercadopago.resources.datastructures.preference.Identification;
import com.mercadopago.resources.datastructures.preference.Payer;
import com.mercadopago.resources.datastructures.preference.Phone;
import tesis.entities.dtos.mercadopago.Consumer;
import tesis.entities.enums.user.DocumentType;

public class PayerBuilder {

    public static Payer buildPayer(Consumer consumer) {

        Payer payer = new Payer();
        payer.setName(consumer.getFirstName())
                .setSurname(consumer.getGivenName())
                .setEmail(consumer.getEmail())
                .setPhone(new Phone()
                        .setAreaCode("351")
                        .setNumber(consumer.getPhone().toString())) //TODO aca hay que sacar los primeros valores
                .setIdentification(new Identification().setType(DocumentType.DNI.toString()).
                        setNumber(consumer.getDni().toString()))
                .setAddress(new Address().setStreetName(consumer.getAddressName()).
                        setZipCode(consumer.getAddressCode().toString()).
                        setStreetNumber(consumer.getAddressNumber()));
        return new Payer();
    }
}
