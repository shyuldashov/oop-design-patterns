package solid.dip;

import java.util.List;


// High-level
public class Research {
    public Research(RelationshipBrowser browser) {
        String testName = "Mike";
        List<Person> children = browser.findAllChildrenOf(testName);
        for (Person child : children) {
            System.out.printf("%s has a child called %s\n", testName, child.getName());
        }
    }
}


class Main {
    public static void main(String[] args) {
        Person parent = new Person("Mike");
        Person childOne = new Person("Sara");
        Person childTwo = new Person("Bob");

        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent, childOne);
        relationships.addParentAndChild(parent, childTwo);

        // Result
        new Research(relationships);
    }
}
