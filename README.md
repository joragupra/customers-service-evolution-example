Customer REST service evolution example
=======================================

Exposed endpoint:
* /api/customers/{customerid} GET : retrieves information about a customer
* /api/customers POST : creates a new customer
* /api/customers/{customerid} PUT : updates the information about an existing customer

Customer information is transmitted in the following JSON format:

{"currentAddress":{"city":"Berlin","postalCode":"10555","streetName":"Turmstrasse","streetNumber":"1"},"firstName":"Frank","lastName":"Freundlich"}

Database persistence configuration
----------------------------------

To persist data, the chosen option has been PostgreSQL, although it should not be difficult to configure the project
to use a different database. The connection can be configured by changing the file *persistence.xml*.

Database changes are handled via Liquibase (http://www.liquibase.org). Schema changes are specified in the file
at _resources/db/master.xml_.

Sample data generation
----------------------

You can run the program *CustomersGenerator* to populate your database with data examples.

Notes
-----

It is recommended to run the service with two separate Jetty instances at the same time to
check how the service can evolve in a compatible way, so one of the instances is always up
and running while the other is updated. To run the project using embedded Jetty:

mvn jetty:run -Djetty.port=[listen_port]