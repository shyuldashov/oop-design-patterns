package structural.decorator;

import java.util.function.Supplier;

public class StaticColoredShape<T extends Shape> implements Shape {
    private Shape shape;
    private String color;

    public StaticColoredShape(
            Supplier<? extends T> constructor,
            String color
    ) {
        shape = constructor.get();
        this.color = color;
    }

    public StaticColoredShape(Shape shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    public String info() {
        return String.format("%s has the color %s", shape.info(), color);
    }
}
