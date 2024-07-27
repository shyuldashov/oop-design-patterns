package structural.decorator;

import java.util.function.Supplier;

public class StaticTransparentShape<T extends Shape> implements Shape {
    private Shape shape;
    private int transparency;

    public StaticTransparentShape(
            Supplier<? extends T> constructor,
            int transparency
    ) {
        shape = constructor.get();
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
