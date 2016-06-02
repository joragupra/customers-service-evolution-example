package com.joragupra;

import com.joragupra.rest.Customers;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class Server extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<>();
        s.add(Customers.class);
        return s;
    }

}
