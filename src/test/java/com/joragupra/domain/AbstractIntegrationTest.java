package com.joragupra.domain;

import com.joragupra.persistence.DatabaseInitializer;
import org.junit.BeforeClass;

public abstract class AbstractIntegrationTest {

    private static DatabaseInitializer database;

    @BeforeClass
    public static void onlyOnce() {
        database = new DatabaseInitializer();
        database.setUp("test");
    }

}