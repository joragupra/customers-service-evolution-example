package com.joragupra;

import com.joragupra.persistence.CustomerRepositoryImpl;
import com.joragupra.persistence.DatabaseInitializer;
import com.joragupra.domain.CustomerService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServerInit implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DatabaseInitializer databaseInitializer = new DatabaseInitializer();
        databaseInitializer.setUp("prod");

        CustomerService.init(new CustomerRepositoryImpl());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
