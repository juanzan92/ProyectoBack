package tesis.entities.builders.mercadopago;

import com.mercadopago.resources.datastructures.preference.BackUrls;

public class BackUrlsBuilder {
    public static BackUrls buildBackUrls() {
        return new BackUrls("http://localhost:3000",
                "http://localhost:3000",
                "http://localhost:3000");
    }
}
