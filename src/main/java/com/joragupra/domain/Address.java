package com.joragupra.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "address")
public class Address {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "street_number")
    private String streetNumber;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "city")
    private String city;
    @Column(name = "address_since")
    private Date addressSince;

    public Address() {
    }

    public Address(String streetName, String streetNumber, String postalCode, String city, Date addressSince) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.addressSince = addressSince;
    }

    public Long id() {
        return id;
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
