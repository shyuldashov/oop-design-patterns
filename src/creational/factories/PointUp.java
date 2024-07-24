package creational.factories;

public class PointUp {
    private double x, y;

    private PointUp(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static class Factory {
        public static PointUp newCartesianPoint(double x, double y) {
            return new PointUp(x, y);
        }

        public static PointUp newPolarPoint(double rho, double theta) {
            return new PointUp(
                    rho * Math.cos(theta),
                    rho * Math.sin(theta)
            );
        }
    }

    @Override
    public String toString() {
        return String.format("Coord1: %.1f; Coord2: %.1f", x, y);
    }
}


class MainTwo {
    public static void main(String[] args) {
        PointUp cartesian = PointUp.Factory.newCartesianPoint(1, 3);
        PointUp polar = PointUp.Factory.newPolarPoint(2, 4);

        System.out.println(cartesian);
        System.out.println(polar);
    }
}