package tesis.entities.builders.mercadopago;

import com.mercadopago.resources.datastructures.preference.BackUrls;

public class BackUrlsBuilder {
    public static BackUrls buildBackUrls() {
        return new BackUrls("localhost:8080/success",
                "localhost:8080/pending",
                "localhost:8080/failure");

    }
}
