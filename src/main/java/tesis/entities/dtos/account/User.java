package tesis.entities.dtos.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import tesis.entities.dtos.ForDynamo;

public class User extends ForDynamo {

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

    public User() {
        super("users", "username");
    }
}
