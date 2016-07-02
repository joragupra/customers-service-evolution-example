package com.joragupra.domain;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CustomerTest {

    @Test
    public void updateAddress() {
        LocalDateTime firstAddressDate = LocalDateTime.now().minusDays(3);
        Customer customer = new Customer("Joe", "Doe", "Lexington Avenue", "12345", "55555", "Atlantis", Date.from(firstAddressDate.atZone(
                ZoneId.systemDefault()).toInstant()));

        final String newStreetName = "Oxford Street";
        final String newStreetNumber = "54321";
        final String newPostalCode = "44444";
        final String newCity = "Babylon";
        final Date addressChangeDate = Calendar.getInstance().getTime();

        customer.updateAddress(newStreetName, newStreetNumber, newPostalCode, newCity, addressChangeDate);

        assertThat(customer.streetName(), is(newStreetName));
        assertThat(customer.streetNumber(), is(newStreetNumber));
        assertThat(customer.postalCode(), is(newPostalCode));
        assertThat(customer.city(), is(newCity));
        assertThat(customer.addressSince(), is(addressChangeDate));

        assertThat(customer.addressHistory().size(), is(2));

    }

    @Test
    public void currentAddress() {
        LocalDateTime firstAddressDate = LocalDateTime.now().minusDays(3);
        Customer customer = new Customer("Joe", "Doe", "Lexington Avenue", "12345", "55555", "Atlantis", Date.from(firstAddressDate.atZone(
                ZoneId.systemDefault()).toInstant()));

        final String newStreetName = "Oxford Street";
        final String newStreetNumber = "54321";
        final String newPostalCode = "44444";
        final String newCity = "Babylon";
        final Date addressChangeDate = Calendar.getInstance().getTime();

        customer.updateAddress(newStreetName, newStreetNumber, newPostalCode, newCity, addressChangeDate);

        assertThat(customer.currentAddress().streetName(), is(newStreetName));
        assertThat(customer.currentAddress().streetNumber(), is(newStreetNumber));
        assertThat(customer.currentAddress().postalCode(), is(newPostalCode));
        assertThat(customer.currentAddress().city(), is(newCity));
        assertThat(customer.currentAddress().addressSince(), is(addressChangeDate));

    }

}
