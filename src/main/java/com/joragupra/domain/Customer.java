package com.joragupra.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "customer")
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
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

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this(firstName, lastName, null, null, null, null, null);
    }

    public Customer(
            String firstName, String lastName, String streetName, String streetNumber, String postalCode, String city
    ) {
        this(firstName, lastName, streetName, streetNumber, postalCode, city, null);
    }

    public Customer(
            String firstName, String lastName, String streetName, String streetNumber, String postalCode, String city, Date addressSince
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        updateAddress(streetName, streetNumber, postalCode, city, addressSince);
    }

    public void updateAddress(String streetName, String streetNumber, String postalCode, String city, Date addressChangeDate) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.addressSince = addressChangeDate;
    }

    public Long id() {
        return id;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
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