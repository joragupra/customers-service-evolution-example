package com.joragupra.domain;

import java.util.Date;

public class CustomerService {

    private static CustomerService INSTANCE;

    private CustomerRepository repository;

    private CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer retrieve(long customerId) {
        return this.repository.findById(customerId);
    }

    public Customer create(Customer customer) {
        if (customer.id() == null) {
            this.repository.save(customer);
        }
        return customer;
    }

    public Customer updateAddress(long customerId, String newStreetName, String newStringNumber, String newPostalCode, String newCity) {
        Customer customer = retrieve(customerId);

        if (customer == null) {
            throw new IllegalArgumentException("No customer found with ID " + customerId);
        }

        customer.updateAddress(newStreetName, newStringNumber, newPostalCode, newCity, new Date());
        this.repository.save(customer);
        return customer;
    }

    public static void init(CustomerRepository repository) {
        if (INSTANCE == null) {
            INSTANCE = new CustomerService(repository);
        }
    }

    public static CustomerService instance() {
        return INSTANCE;
    }

}
