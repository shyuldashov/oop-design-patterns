package solid.lsp;

public class Rectangle {
    protected int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return String.format("\nWidth: %d, Height: %d", width, height);
    }
}

class Square extends Rectangle {

    public Square(int size) {
        super(size, size);
    }

    @Override
    public void setWidth(int size) {
        super.setWidth(size);
        super.setHeight(size);
    }

    @Override
    public void setHeight(int size) {
        super.setHeight(size);
        super.setWidth(size);
    }
}

class Main {
    public static void testThisObject(Rectangle obj) {
        int testValue = 8;
        int width = obj.getWidth();
        obj.setHeight(testValue);

        int expected = width * testValue;
        int result = obj.getArea();

        System.out.printf("Expected an area of %d, got %d\n", expected, result);

    }

    public static void main(String[] args) {
        Rectangle rc = new Rectangle(4, 3);
        testThisObject(rc);  // Expected an area of 32, got 32

        Square sq = new Square(2);
        testThisObject(sq);  // Expected an area of 16, got 64

        // SOLVE: The solution to this problem is the Factory design pattern.
    }
}
