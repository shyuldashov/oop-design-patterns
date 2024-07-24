package creational.factories;

public enum CoordinateSystem {
    CARTESIAN(0),
    POLAR(1);

    private final int value;

    CoordinateSystem(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
