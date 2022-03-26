package com.joragupra.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import liquibase.Liquibase;
import liquibase.database.core.PostgresDatabase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.FileSystemResourceAccessor;
import liquibase.resource.ResourceAccessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseInitializer {
    private static final String CHANGE_LOG        = "src/main/resources/db/master.xml";
    private static final String CONNECTION_STRING = "jdbc:postgresql://localhost:5432/sandboxDb";
    private static final String USER_NAME         = "sandbox";
    private static final String PASSWORD          = "sandbox";
    private static final Logger LOG               = LoggerFactory.getLogger(DatabaseInitializer.class);
    private Connection holdingConnection;
    private Liquibase liquibase;


    public void setUp(String contexts) {
        try {
            LOG.info("Updating database...");
            ResourceAccessor resourceAccessor = new FileSystemResourceAccessor();
            Class.forName("org.postgresql.Driver");

            holdingConnection = getConnectionImpl();

            PostgresDatabase postgresDatabase = new PostgresDatabase();
            postgresDatabase.setConnection(new JdbcConnection(holdingConnection));
            liquibase = new Liquibase(CHANGE_LOG, resourceAccessor, postgresDatabase.getConnection());
            liquibase.update(contexts);
            postgresDatabase.getConnection().close();
        } catch (Exception ex) {
            LOG.error("Error during database initialization", ex);
            throw new RuntimeException("Error during database initialization", ex);
        }
    }

    private Connection getConnectionImpl() throws SQLException {
        return DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);
    }

}
