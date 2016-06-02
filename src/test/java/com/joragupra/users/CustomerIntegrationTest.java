package com.joragupra.users;

import com.joragupra.persistence.CustomerRepositoryImpl;
import com.joragupra.persistence.PersistenceManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.UUID;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CustomerIntegrationTest extends AbstractIntegrationTest {

    private EntityManager entityManager;

    private CustomerRepository customerRepository;

    @Before
    public void setUp() {
        entityManager = PersistenceManager.getInstance().getEntityManager();
        entityManager.getTransaction().begin();

        customerRepository = new CustomerRepositoryImpl();
    }

    @After
    public void tearDown() {
        entityManager.getTransaction().rollback();
    }

    @Test
    public void saveAndCount() {
        final long initialCustomers = customerRepository.count();
        final int newCustomers = getNumberOfNewCustomers();

        IntStream.range(1, newCustomers).forEach(i -> customerRepository.save(createRandomCustomer()));

        long customers = customerRepository.count();

        assertThat((int) customers, is(newCustomers - 1 + initialCustomers));
    }

    private int getNumberOfNewCustomers() {
        return 1 + (int) (Math.random() * 50);
    }

    private Customer createRandomCustomer() {
        return new Customer(UUID.randomUUID().toString(), UUID.randomUUID().toString());
    }

}
