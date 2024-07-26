package structural.adapter;


public class Square {
    public int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public String toString() {
        return String.format("Square(side=%d)", side);
    }
}
