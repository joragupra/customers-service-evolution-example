package com.joragupra.rest;

import com.joragupra.domain.Customer;

class CustomerMapper {

    static CustomerDto fromDomainToDto(Customer c) {
        return new CustomerDto(c.firstName(), c.lastName(),
                               new AddressDto(c.currentAddress().streetName(), c.currentAddress().streetNumber(), c.currentAddress().postalCode(), c.currentAddress().city(), c.currentAddress().addressSince())
        );
    }

    static Customer fromDtoToDomain(CustomerDto customerDto) {
        if (customerDto.getCurrentAddress() != null) {
            return new Customer(customerDto.getFirstName(), customerDto.getLastName(),
                                customerDto.getCurrentAddress().getStreetName(),
                                customerDto.getCurrentAddress().getStreetNumber(),
                                customerDto.getCurrentAddress().getPostalCode(), customerDto.getCurrentAddress().getCity()
            );
        } else {
            return new Customer(customerDto.getFirstName(), customerDto.getLastName());
        }
    }

}
