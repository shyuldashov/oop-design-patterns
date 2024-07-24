package creational.factories;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public int id;
    public String name;


    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Person(id=%d, name=%s)", id, name);
    }
}


class PersonFactory {
    private static int idCount = 0;

    public static Person createPerson(String name) {
        idCount++;
        return new Person(idCount, name);
    }
}


class TestCase {
    public static void main(String[] args) {
        String[] names = {"Ann", "Bob", "Sara", "Mike"};
        List<Person> personList = new ArrayList<>();

        // Create new objects
        for (String name : names) {
            Person obj = PersonFactory.createPerson(name);
            personList.add(obj);
        }

        // Print objects
        for (Person person : personList) {
            System.out.println(person);
        }
    }
}

