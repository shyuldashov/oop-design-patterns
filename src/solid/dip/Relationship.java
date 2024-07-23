package solid.dip;

public enum Relationship {
    PARENT(0),
    CHILD(1),
    SIBLING(2);

    private final int value;

    Relationship(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
