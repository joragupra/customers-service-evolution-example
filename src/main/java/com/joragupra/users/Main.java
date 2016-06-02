package com.joragupra.users;

import com.joragupra.persistence.DatabaseInitializer;
import com.joragupra.persistence.PersistenceManager;

import javax.persistence.EntityManager;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("Jorge", "Agudo");

        new DatabaseInitializer().setUp("test");

        EntityManager em = PersistenceManager.getInstance().getEntityManager();

        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
        em.close();

        PersistenceManager.getInstance().close();
    }

}
