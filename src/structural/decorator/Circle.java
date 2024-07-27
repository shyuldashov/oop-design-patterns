package structural.decorator;

public class Circle implements Shape {
    private float radius;

    public Circle() {

    }

    public Circle(float radius) {
        this.radius = radius;
    }

    void resize(float factor) {
        radius *= factor;
    }

    @Override
    public String info() {
        return String.format("A circle of radius %.2f", radius);
    }
}
