package creational.prototype;

// Wrong approach to cloning an object


import java.util.Arrays;

class AddressTwo implements Cloneable {
    public String streetName;
    public int houseNum;

    public AddressTwo(String streetName, int houseNum) {
        this.streetName = streetName;
        this.houseNum = houseNum;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new AddressTwo(streetName, houseNum);
    }

    @Override
    public String toString() {
        return String.format(
                "AddressTwo(streetName=\"%s\", houseNum=%d)",
                streetName, houseNum
        );
    }
}


public class Person {
    public String[] names;
    public AddressTwo addressTwo;

    public Person(String[] names, AddressTwo addressTwo) {
        this.names = names;
        this.addressTwo = addressTwo;
    }

    // Deep copy
    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Person(
                names.clone(),
                (AddressTwo) addressTwo.clone()  // Incorrect
        );
    }

    @Override
    public String toString() {
        return String.format("Person(names=%s, addressTwo=%s)\n",
                Arrays.toString(names), addressTwo
        );
    }
}


class Main {
    public static void main(String[] args) throws Exception {
        Person ivan = new Person(
                new String[]{"Ivan", "Ivanov"},
                new AddressTwo("Tverskaya Street, Moscow", 13)
        );


        //  Person anna = ivan;  // Without Cloneable interface
        Person anna = (Person) ivan.clone();  // With Cloneable interface
        anna.names[0] = "Anna";
        anna.names[1] = "Ivanova";
        anna.addressTwo.houseNum = 21;

        System.out.println(ivan);
        System.out.println(anna);
    }
}