package com.joragupra.users;

import org.junit.Test;

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

        customer.updateAddress(newStreetName, newStreetNumber, newPostalCode, newCity);

        assertThat(customer.streetName(), is(newStreetName));
        assertThat(customer.streetNumber(), is(newStreetNumber));
        assertThat(customer.postalCode(), is(newPostalCode));
        assertThat(customer.city(), is(newCity));

    }
}
