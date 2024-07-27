package structural.decorator;

public class DynamicColoredShape implements Shape {
    private Shape shape;
    private String color;

    public DynamicColoredShape(Shape shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    public String info() {
        return String.format("%s has the color %s", shape.info(), color);
    }

}
