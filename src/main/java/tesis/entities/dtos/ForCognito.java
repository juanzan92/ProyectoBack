package tesis.entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForCognito {

    @JsonProperty("user_pool_id")
    String userPoolId;

    @JsonProperty("username")
    String username;

    public ForCognito(String userPoolId, String username){
        this.userPoolId = userPoolId;
        this.username = username;
    }

    public ForCognito(){}

    public String getUserPoolId() {
        return userPoolId;
    }

    public void setUserPoolId(String userPoolId) {
        this.userPoolId = userPoolId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
