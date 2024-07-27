package structural.decorator;

public class DynamicDecorator {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println(circle.info());

        // --------------------

        DynamicColoredShape dynamicColoredShape = new DynamicColoredShape(
                new Square(3), "green"
        );
        System.out.println(dynamicColoredShape.info());

        // --------------------

        DynamicTransparentShape dynamicTransparentShape = new DynamicTransparentShape(
                new DynamicColoredShape(
                        new Circle(9), "yellow"
                ), 45
        );

        // dynamicTransparentShape.resize() does not work
        // as DynamicTransparentShape does not inherit
        System.out.println(dynamicTransparentShape.info());
        // --------------------
        // --------------------

    }
}
