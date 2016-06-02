package com.joragupra.utils;

import com.joragupra.persistence.CustomerRepositoryImpl;
import com.joragupra.domain.Customer;
import com.joragupra.domain.CustomerService;

import java.util.stream.IntStream;

public class CustomersGenerator {

    private static final String[] FIRST_NAME_POOL = new String[]{
            "Achim", "Baldur", "Dietmar", "Oskar", "Kuno", "Ruprecht", "Augustin", "Gunter", "Yannick", "Wilfried",
            "Susanne", "Marion", "Ramona", "Luisa", "Ute", "Fridegunde", "Marina", "Sina", "Kaete", "Petrus",
            "Eckehard", "Pascal", "Erik", "Wilfried", "Adelar", "Frank", "Reinhard", "Jens", "Hubert", "Christiane",
            "Tamara", "Liane", "Esther", "Wanja", "Amelie", "Rita", "Corina", "Viktoria", "Janina"
    };


    private static final String[] LAST_NAME_POOL = new String[]{
            "Boehm", "Koeppen", "Kraus", "Kornfeld", "Spindler", "Felsenbaum", "Vetter", "Rozenkwit", "Heller",
            "Trausch", "Ullrich", "Hengsbach", "Tischbein", "Weingaertner", "Trauth", "Wechsler", "Bohm",
            "Hasselvander", "Schrempf", "Maisel", "Scheu", "Katzenbach", "Hoenigswald", "Reichwein", "Guttenberg",
            "Kolb", "Woerfel", "Schachner", "Luxenberg", "Freundlich", "Baten", "Koeppen", "Heim", "Rosenthal",
            "Dinter", "Tausche", "Fleiss", "Eisenmenger", "Boerngen", "Christmann"
    };

    private static final String[] STREET_NAME_POOL = new String[]{
            "3rd Street", "Hickory Street", "4th Street North", "Forest Street", "Lilac Lane", "Cleveland Street",
            "Route 32", "Canal Street", "George Street", "Orchard Street", "Orchard Lane", "Pheasant Run",
            "Henry Street", "Orchard Avenue", "Maiden Lane", "Smith Street", "Front Street North", "Water Street",
            "Windsor Court", "Poplar Street", "Heritage Drive", "Willow Lane", "Colonial Avenue", "Westminster Drive",
            "Parker Street", "Route 7", "Fairview Avenue", "Route 29", "Railroad Street", "Mulberry Lane",
            "10th Street", "Glenwood Avenue", "Walnut Avenue", "Olive Street", "Cedar Street", "Laurel Street",
            "6th Avenue", "Amherst Street", "Garden Street", "Clay Street", "Cottage Street", "Rosewood Drive",
            "Holly Court", "Inverness Drive", "Linda Lane", "Main Street East", "Jefferson Street", "Front Street",
            "Woodland Drive", "Evergreen Drive", "Woodland Avenue", "Jefferson Court", "Division Street", "Cedar Court",
            "Ivy Court", "Broad Street West", "Mulberry Street", "5th Street West", "Magnolia Drive", "Grove Street",
            "Academy Street", "Laurel Drive", "Heather Court", "Andover Court", "Meadow Lane", "Oak Lane",
            "3rd Street West", "Columbia Street", "Walnut Street", "Prospect Avenue", "Old York Road", "Forest Avenue",
            "Hickory Lane", "Warren Avenue", "Morris Street", "11th Street", "Summer Street", "Sycamore Lane",
            "Canterbury Road", "York Street", "Elm Avenue", "North Avenue", "Hawthorne Lane", "Taylor Street",
            "Strawberry Lane", "Broadway", "Route 17", "Franklin Avenue", "Park Street", "5th Street East",
            "Virginia Street", "Grand Avenue", "Highland Avenue", "River Street", "14th Street", "Washington Avenue",
            "Franklin Street", "New Street", "Hamilton Street", "7th Street"
    };

    private static final String[] CITY_POOL = new String[]{
            "Berlin", "Hamburg", "Muenchen", "Cologne", "Frankfurt am Main", "Stuttgart", "Duesseldorf", "Dortmund",
            "Essen", "Bremen"
    };

    public static void generateCustomer() {
        final String firstName = takeRandomFrom(FIRST_NAME_POOL);
        final String lastName = takeRandomFrom(LAST_NAME_POOL);

        CustomerService.init(new CustomerRepositoryImpl());

        if (withAddress()) {
            final String streetName = takeRandomFrom(STREET_NAME_POOL);
            final int streetNumber = (int) (Math.random() * 100);
            final int postalCode = (int) (Math.random() * 10000);
            final String city = takeRandomFrom(CITY_POOL);
            CustomerService.instance()
                           .create(new Customer(firstName, lastName, streetName, "" + streetNumber, "" + postalCode,
                                                city
                           ));
        } else {
            CustomerService.instance().create(new Customer(firstName, lastName));
        }
    }

    private static String takeRandomFrom(String[] pool) {
        return pool[(int) (Math.random() * (pool.length - 1))];
    }

    private static boolean withAddress() {
        return Math.random() > 0.5;
    }

    public static void main(String[] args) {
        IntStream.range(1, 2000).forEach(i -> generateCustomer());
    }

}
