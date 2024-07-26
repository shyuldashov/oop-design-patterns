package structural.bridge;


public class Circle extends Shape {
    public float radius;

    public Circle(Renderer renderer) {
        super(renderer);
    }

    public Circle(Renderer renderer, float radius) {
        super(renderer);
        this.radius = radius;
    }

    @Override
    public void draw() {
        renderer.renderCircle(radius);
    }

    @Override
    public void resize(float factor) {
        radius *= factor;
    }
}


class MainTwo {
    public static void main(String[] args) {
        RasterRenderer raster = new RasterRenderer();
        VectorRenderer vector = new VectorRenderer();

        // --------------------

        // Circle circle = new Circle(vector, 5);
        Circle circle = new Circle(raster, 5);
        circle.draw();
        circle.resize(2);
        circle.draw();

    }
}
