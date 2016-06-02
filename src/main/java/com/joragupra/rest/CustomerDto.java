package com.joragupra.rest;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class CustomerDto implements Serializable {

    private String firstName;

    private String lastName;

    private AddressDto currentAddress;

    public CustomerDto() {
    }

    public CustomerDto(
            String firstName, String lastName, AddressDto currentAddress
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.currentAddress = currentAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AddressDto getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(AddressDto currentAddress) {
        this.currentAddress = currentAddress;
    }
}
