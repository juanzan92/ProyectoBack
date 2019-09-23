package tesis.entities.dtos.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import tesis.entities.dtos.mercadopago.Address;

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

    @JsonProperty("phone")
    private Long phone;

    @JsonProperty("dni")
    private Long dni;

    @JsonProperty("address")
    private Address address;

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public Long getPhone() {
        return phone;
    }

    public User setPhone(Long phone) {
        this.phone = phone;
        return this;
    }

    public Long getDni() {
        return dni;
    }

    public User setDni(Long dni) {
        this.dni = dni;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public User setAddress(Address address) {
        this.address = address;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUserRole() {
        return userRole;
    }

    public User setUserRole(String userRole) {
        this.userRole = userRole;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }
}
