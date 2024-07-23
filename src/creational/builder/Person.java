package creational.builder;

public class Person {
    // Address
    public String streetAddress, postcode, city;

    // Employment info
    public String companyName, position;
    public int annualIncome;

    public Person() {
        System.out.println("Creating an instance of Person...");
    }

    @Override
    public String toString() {
        return String.format(
                "Address: %s, %s, %s.\nEmployed at \"%s\" as a %s earning %d.",
                streetAddress, postcode, city, companyName, position, annualIncome
        );
    }
}

class Main {
    public static void main(String[] args) {
        PersonBuilder pb = new PersonBuilder();
        Person person = pb
                .lives()
                    .at("221 Baker Street")
                    .withPostcode("NW1 6XE")
                    .inCity("London")
                .works()
                    .at("ShH & DW Company")
                    .asA("Consulting Detective")
                    .earning(221239)
                .build();

        System.out.println(person);
        // Output
        /*
        Creating an instance of Person...
        Creating an instance of Person...
        Creating an instance of Person...
        Address: 221 Baker Street, NW1 6XE, London.
        Employed at "ShH & DW Company" as a Consulting Detective earning 221239.
         */

        // --------------------

        Person person1 = new PersonBuilder().build();

        System.out.println(person1);
        // Output
        /*
        Creating an instance of Person...
        Address: null, null, null.
        Employed at "null" as a null earning 0.
         */
    }
}
