package com.joragupra.persistence;

import com.joragupra.domain.Customer;
import com.joragupra.domain.CustomerRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CustomerRepositoryImpl implements CustomerRepository {

    private EntityManager entityManager = PersistenceManager.getInstance().getEntityManager();

    @Override
    public Customer findById(Long id) {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
            Root<Customer> root = cq.from(Customer.class);
            cq.select(root).where(cb.equal(root.get("id"), id));
            TypedQuery<Customer> query = entityManager.createQuery(cq);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
    }

    @Override
    public long count() {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        cq.select(qb.count(cq.from(Customer.class)));
        return entityManager.createQuery(cq).getSingleResult();
    }
}
