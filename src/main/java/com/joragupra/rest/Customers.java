package com.joragupra.rest;

import com.joragupra.domain.Customer;
import com.joragupra.domain.CustomerService;
import com.owlike.genson.Genson;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.joragupra.rest.CustomerMapper.*;

@Path("customers")
public class Customers {

    @GET
    @Path("{customerid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam("customerid") String customerId) {
        Customer c = CustomerService.instance().retrieve(Long.parseLong(customerId));
        if (c == null) {
            return Response.status(404).build();
        }
        return Response.status(200).entity(fromDomainToDto(c)).build();
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createCustomer(String newCustomerJson) {
        CustomerDto newCustomer = new Genson().deserialize(newCustomerJson, CustomerDto.class);

        return Response.status(201).entity(CustomerService.instance().create(fromDtoToDomain(newCustomer)).id())
                       .build();
    }

    @PUT
    @Path("{customerid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateCustomer(@PathParam("customerid") String customerId, String updatedCustomerJson) {
        CustomerDto updatedCustomer = new Genson().deserialize(updatedCustomerJson, CustomerDto.class);

        if (updatedCustomer.getCurrentAddress() != null) {
            try {
                Customer customer = CustomerService.instance().updateAddress(Long.parseLong(customerId),
                                                                             updatedCustomer.getCurrentAddress()
                                                                                            .getStreetName(),
                                                                             updatedCustomer.getCurrentAddress()
                                                                                            .getStreetNumber(),
                                                                             updatedCustomer.getCurrentAddress()
                                                                                            .getPostalCode(),
                                                                             updatedCustomer.getCurrentAddress()
                                                                                            .getCity()
                );
                return Response.status(200).entity(customer.id()).build();
            } catch (IllegalArgumentException e) {
                return Response.status(404).build();
            }
        }

        return Response.status(204).build();
    }

}
