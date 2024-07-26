package structural.bridge;

public class VectorRenderer implements Renderer {
    @Override
    public void renderCircle(float radius) {
        System.out.printf("Drawing a circle of radius %.1f%n", radius);
    }
}
