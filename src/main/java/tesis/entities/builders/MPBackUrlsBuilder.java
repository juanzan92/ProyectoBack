package tesis.entities.builders;

import com.mercadopago.resources.datastructures.preference.BackUrls;

public class MPBackUrlsBuilder {
    public static BackUrls buildBackUrls(){

        BackUrls backUrls = new BackUrls("localhost:8080/success",
                "localhost:8080/pending",
                "localhost:8080/failure");

        return backUrls;
    }
}
