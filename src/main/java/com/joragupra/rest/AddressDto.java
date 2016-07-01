package com.joragupra.rest;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class AddressDto {

    private String streetName;

    private String streetNumber;

    private String postalCode;

    private String city;

    private Date inUseSince;

    public AddressDto() {
    }

    public AddressDto(String streetName, String streetNumber, String postalCode, String city) {
        this(streetName, streetNumber, postalCode, city, null);
    }

    public AddressDto(String streetName, String streetNumber, String postalCode, String city, Date inUseSince) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.inUseSince = inUseSince;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getInUseSince() {
        return inUseSince;
    }

    public void setInUseSince(Date inUseSince) {
        this.inUseSince = inUseSince;
    }
}
