package solid.dip;

public class TripletTuple<U, V, W> {
    private U first;
    private V second;
    private W third;

    public TripletTuple(U first, V second, W third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public U getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public W getThird() {
        return third;
    }
}
