package com.joragupra.domain;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CustomerTest {

    @Test
    public void updateAddress() {
        Customer customer = new Customer("Joe", "Doe", "Lexington Avenue", "12345", "55555", "Atlantis");

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

    }
}
