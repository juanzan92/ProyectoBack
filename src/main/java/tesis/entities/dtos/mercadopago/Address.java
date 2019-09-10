package tesis.entities.dtos.mercadopago;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    @JsonProperty("zip_code")
    private String zipCode = null;

    @JsonProperty("street_name")
    private String streetName = null;

    @JsonProperty("street_number")
    private Integer streetNumber = null;

    @JsonProperty("floor")
    private String floor = null;

    @JsonProperty("apartment")
    private String apartment = null;

    public String getZipCode() {
        return zipCode;
    }

    public Address setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getStreetName() {
        return streetName;
    }

    public Address setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public Address setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    public String getFloor() {
        return floor;
    }

    public Address setFloor(String floor) {
        this.floor = floor;
        return this;
    }

    public String getApartment() {
        return apartment;
    }

    public Address setApartment(String apartment) {
        this.apartment = apartment;
        return this;
    }
}
