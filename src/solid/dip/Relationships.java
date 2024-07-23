package solid.dip;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


// Low-level module
public class Relationships implements RelationshipBrowser {
    private final List<TripletTuple<Person, Relationship, Person>> relations = new ArrayList<>();

    public List<TripletTuple<Person, Relationship, Person>> getRelations() {
        return relations;
    }

    public void addParentAndChild(Person parent, Person child) {
        relations.add(new TripletTuple<>(parent, Relationship.PARENT, child));
        relations.add(new TripletTuple<>(child, Relationship.CHILD, parent));
    }

    @Override
    public List<Person> findAllChildrenOf(String name) {
        return relations.stream().filter(
                x -> x.getFirst().getName().equals(name) && x.getSecond() == Relationship.PARENT
        ).map(TripletTuple::getThird).collect(Collectors.toList());
    }
}
