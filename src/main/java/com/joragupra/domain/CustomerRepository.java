package com.joragupra.domain;

public interface CustomerRepository {

    Customer findById(Long id);

    void save(Customer customer);

    long count();

}
