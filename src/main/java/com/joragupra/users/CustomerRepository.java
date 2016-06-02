package com.joragupra.users;

public interface CustomerRepository {

    Customer findById(Long id);

    void save(Customer customer);

    long count();

}
