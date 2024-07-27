package structural.decorator;

public class StaticDecorator {
    public static void main(String[] args) {
        StaticColoredShape<Square> staticColoredShape = new StaticColoredShape<>(
                () -> new Square(12),
                "orange"
        );
        System.out.println(staticColoredShape.info());

        // --------------------

        StaticTransparentShape<StaticColoredShape<Circle>> transparentShapeCircle = new StaticTransparentShape<>(
                () -> new StaticColoredShape<>(
                        () -> new Circle(7),
                        "red"),
                65
        );
        // transparentShapeCircle.resize() not possible since
        // TransparentShape does not inherit from Circle
        System.out.println(transparentShapeCircle.info());
    }
}
