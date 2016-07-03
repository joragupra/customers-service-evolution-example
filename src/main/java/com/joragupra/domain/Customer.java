package com.joragupra.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Comparator.comparing;

@Entity(name = "customer")
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private List<Address> addressHistory;// = new ArrayList<>();

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressHistory = new ArrayList<>();
    }

    public Customer(
            String firstName, String lastName, String streetName, String streetNumber, String postalCode, String city
    ) {
        this(firstName, lastName, streetName, streetNumber, postalCode, city, null);
    }

    public Customer(
            String firstName, String lastName, String streetName, String streetNumber, String postalCode, String city, Date addressSince
    ) {
        this(firstName, lastName);
        updateAddress(streetName, streetNumber, postalCode, city, addressSince);
    }

    public void updateAddress(String streetName, String streetNumber, String postalCode, String city, Date addressChangeDate) {
        this.addressHistory.add(new Address(streetName, streetNumber, postalCode, city, addressChangeDate));
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

    public Address currentAddress() {
        return addressHistory().stream().sorted(comparing(Address::addressSince).reversed()).findFirst().get();
    }

    public List<Address> addressHistory() {
        List<Address> addressHistoryCopy = new ArrayList<>(this.addressHistory);
        return addressHistoryCopy;
    }

    public String streetName() {
        return currentAddress().streetName();
    }

    public String streetNumber() {
        return currentAddress().streetNumber();
    }

    public String postalCode() {
        return currentAddress().postalCode();
    }

    public String city() {
        return currentAddress().city();
    }

    public Date addressSince() {
        return currentAddress().addressSince();
    }
}