package com.joragupra.domain;

import java.util.Date;

public class Address {

    private String streetName;
    private String streetNumber;
    private String postalCode;
    private String city;
    private Date   addressSince;

    public Address(String streetName, String streetNumber, String postalCode, String city, Date addressSince) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.addressSince = addressSince;
    }

    public String streetName() {
        return streetName;
    }

    public String streetNumber() {
        return streetNumber;
    }

    public String postalCode() {
        return postalCode;
    }

    public String city() {
        return city;
    }

    public Date addressSince() {
        return addressSince;
    }

}
