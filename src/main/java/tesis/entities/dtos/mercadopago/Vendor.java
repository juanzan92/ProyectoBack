package tesis.entities.dtos.mercadopago;

import com.fasterxml.jackson.annotation.JsonProperty;
import tesis.entities.dtos.ForDynamo;

public class Vendor extends ForDynamo {
    public Vendor() {
        super("users", "username");
    }

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("public_key")
    private String publicKey;

    @JsonProperty("refresh_token")
    private String refreshToken;

    private String username;

    public String getUsername() {
        return username;
    }

    public Vendor setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
