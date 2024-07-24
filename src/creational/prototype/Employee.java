package creational.prototype;

// The correct approach to cloning an object

import java.util.Arrays;

class Address {
    String streetAddress, city, country;

    public Address(String streetAddress, String city, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
    }

    public Address(Address otherObj) {
        this(otherObj.streetAddress, otherObj.city, otherObj.country);
    }

    @Override
    public String toString() {
        return String.format(
                "Address(streetAddress=\"%s\", city=\"%s\", country=\"%s\")",
                streetAddress, city, country
        );
    }
}


public class Employee {
    public String name;
    public Address address;

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Copy constructor
    public Employee(Employee otherObj) {
        name = otherObj.name;
        address = new Address(otherObj.address);
    }

    @Override
    public String toString() {
        return String.format("Employee(name=\"%s\", address=%s)\n",
                name, address
        );
    }
}


class MainTwo {
    public static void main(String[] args) {
        Employee ivan = new Employee(
                "Ivan",
                new Address("Mir Avenue 8", "Moscow", "RU")
        );
        Employee anna = new Employee(ivan);
        anna.name = "Anna";
        anna.address.streetAddress = "Tverskaya Street 13";

        System.out.println(ivan);
        System.out.println(anna);
    }
}
