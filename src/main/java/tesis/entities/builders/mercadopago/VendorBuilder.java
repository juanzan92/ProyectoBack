package tesis.entities.builders.mercadopago;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.validation.constraints.NotNull;

public class VendorBuilder {

    public static MultiValueMap<String, String> buildVendorForDynamo(@NotNull String authCode, @NotNull String userId) {
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("client_id", "7662807553309957");
        requestBody.add("client_secret", "bhvJ3QKMypEzzphnnLhqdkQ5LVVZQx1n");
        requestBody.add("grant_type", "authorization_code");
        requestBody.add("code", authCode);
        requestBody.add("redirect_uri", "http://localhost:3000/splash?user_id=" + userId);

        return requestBody;
    }
}
