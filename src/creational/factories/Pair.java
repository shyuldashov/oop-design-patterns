package creational.factories;


public class Pair<D, O> {
    private final D drinkName;
    private final O drinkFactoryObject;

    public Pair(D first, O second) {
        this.drinkName = first;
        this.drinkFactoryObject = second;
    }

    public D getDrinkName() {
        return drinkName;
    }

    public O getDrinkFactoryObject() {
        return drinkFactoryObject;
    }

}
