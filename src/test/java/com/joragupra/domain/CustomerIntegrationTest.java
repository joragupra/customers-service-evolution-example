package com.joragupra.domain;

import com.joragupra.persistence.CustomerRepositoryImpl;
import com.joragupra.persistence.PersistenceManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.UUID;
import java.util.stream.IntStream;

public class CustomerIntegrationTest extends AbstractIntegrationTest {

    private EntityManager entityManager;

    private CustomerRepository customerRepository;

    @Before
    public void setUp() {
        entityManager = PersistenceManager.getInstance().getEntityManager();
        entityManager.getTransaction().begin();

        customerRepository = new CustomerRepositoryImpl();

        CustomerService.init(customerRepository);
    }

    @After
    public void tearDown() {
        entityManager.getTransaction().rollback();
    }

    @Test
    public void findById() {
        customerRepository.findById(999L);
    }

    @Test
    public void create() {
        Customer c = CustomerService.instance().create(createRandomCustomer());
        Assert.assertNotNull(c.id());
    }

    @Test
    public void create_NewCustomerIsSaved() {
        final long initialCustomers = customerRepository.count();
        final int newCustomers = getNumberOfNewCustomers();

        IntStream.range(1, newCustomers).forEach(i -> CustomerService.instance().create(createRandomCustomer()));

        Assert.assertEquals(initialCustomers + newCustomers - 1, customerRepository.count());
    }

    private int getNumberOfNewCustomers() {
        return 1 + (int) (Math.random() * 50);
    }

    @Test
    public void updateAddress() {
        Customer c = CustomerService.instance().create(createRandomCustomer());
        final String newStreetName = UUID.randomUUID().toString();
        final String newStreetNumber = UUID.randomUUID().toString();
        final String newPostalCode = UUID.randomUUID().toString();
        final String newCity = UUID.randomUUID().toString();

        CustomerService.instance().updateAddress(c.id(), newStreetName, newStreetNumber, newPostalCode, newCity);

        Assert.assertEquals(newStreetName, CustomerService.instance().retrieve(c.id()).streetName());
        Assert.assertEquals(newStreetNumber, CustomerService.instance().retrieve(c.id()).streetNumber());
        Assert.assertEquals(newPostalCode, CustomerService.instance().retrieve(c.id()).postalCode());
        Assert.assertEquals(newCity, CustomerService.instance().retrieve(c.id()).city());
    }

    private Customer createRandomCustomer() {
        return new Customer(UUID.randomUUID().toString(), UUID.randomUUID().toString());
    }

}
