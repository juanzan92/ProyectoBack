package tesis.entities.dtos.mercadopago;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    @JsonProperty("address_name")
    private String addressName;

    @JsonProperty("address_number")
    private int addressNumber;

    @JsonProperty("address_code")
    private Long addressCode;

    @JsonProperty("floor")
    private String floor = null;

    @JsonProperty("apartment")
    private String apartment = null;

    @JsonProperty("address_country")
    private String addressCountry;

    @JsonProperty("address_region")
    private String addressRegion;

    @JsonProperty("address_city")
    private String addressCity;
    
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

    public String getAddressName() {
        return addressName;
    }

    public Address setAddressName(String addressName) {
        this.addressName = addressName;
        return this;
    }

    public int getAddressNumber() {
        return addressNumber;
    }

    public Address setAddressNumber(int addressNumber) {
        this.addressNumber = addressNumber;
        return this;
    }

    public Long getAddressCode() {
        return addressCode;
    }

    public Address setAddressCode(Long addressCode) {
        this.addressCode = addressCode;
        return this;
    }
}
