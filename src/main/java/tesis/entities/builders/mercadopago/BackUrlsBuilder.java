package tesis.entities.builders.mercadopago;

import com.mercadopago.resources.datastructures.preference.BackUrls;

public class BackUrlsBuilder {
    public static BackUrls buildBackUrls() {
        return new BackUrls("http://localhost:3000/splash_congrats",
                "http://localhost:3000/for_ever_error",
                "http://localhost:3000/for_ever_error");
    }
}
