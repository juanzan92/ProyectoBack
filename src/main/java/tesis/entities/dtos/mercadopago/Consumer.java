package tesis.entities.dtos.mercadopago;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Consumer {
    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("given_name")
    private String givenName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private Long phone;

    @JsonProperty("dni")
    private Long dni;

    @JsonProperty("address_name")
    private String addressName;

    @JsonProperty("address_number")
    private int addressNumber;

    @JsonProperty("address_code")
    private Long addressCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public int getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(int addressNumber) {
        this.addressNumber = addressNumber;
    }

    public Long getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(Long addressCode) {
        this.addressCode = addressCode;
    }
}
