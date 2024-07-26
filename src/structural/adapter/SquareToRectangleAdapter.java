package structural.adapter;

public class SquareToRectangleAdapter implements Rectangle {
    protected Square square;

    public SquareToRectangleAdapter(Square square) {
        this.square = square;
    }

    // Adapt square to rectangle interface
    @Override
    public int getWidth() {
        return square.side;
    }

    @Override
    public int getHeight() {
        return square.side;
    }

    @Override
    public int getArea() {
        return square.side * square.side;
    }

    @Override
    public String toString() {
        return String.format(
                "%s%nWidth: %d%nHeight: %d%nArea: %d%n",
                this.getClass().getName(),
                getWidth(),
                getHeight(),
                getArea()
        );
    }
}


class Main {
    public static void main(String[] args) {
        Square square = new Square(5) {
        };

        // The following API is not available in Square
        /*
        square.getWidth();
        square.getHeight();
        square.getArea();
        */
        System.out.println(square);

        // --------------------

        //Issue resolved, API is now available in Square
        SquareToRectangleAdapter squareAdapter = new SquareToRectangleAdapter(square);
        squareAdapter.getWidth();
        squareAdapter.getHeight();
        squareAdapter.getArea();
        System.out.println(squareAdapter);
    }
}
