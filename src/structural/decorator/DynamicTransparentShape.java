package structural.decorator;

public class DynamicTransparentShape implements Shape {
    private Shape shape;
    private int transparency;

    public DynamicTransparentShape(Shape shape, int transparency) {
        this.shape = shape;
        this.transparency = transparency;
    }


    @Override
    public String info() {
        return String.format(
                "%s has %d%% transparency",
                shape.info(), transparency
        );
    }
}
