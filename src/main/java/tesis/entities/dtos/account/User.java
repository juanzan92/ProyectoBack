package tesis.entities.dtos.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty("username")
    private String username;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("user_role")
    private String userRole;

    @JsonProperty("email")
    private String email;
}
