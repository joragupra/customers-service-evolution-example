package com.joragupra.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this(firstName, lastName, null, null, null, null);
    }

    public Customer(
            String firstName, String lastName, String streetName, String streetNumber, String postalCode, String city
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        updateAddress(streetName, streetNumber, postalCode, city);
    }

    public void updateAddress(String streetName, String streetNumber, String postalCode, String city) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
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
}