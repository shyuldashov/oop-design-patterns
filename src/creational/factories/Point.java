package creational.factories;


public class Point {
    private double x, y;

    /* Simple constructor
    Making a constructor private forces user to use factory methods
     */
    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /*  Illegal constructor - already have a constructor with two double values
    public Point(double rho, double theta) {
        x = rho * Math.cos(theta);
        y = rho * Math.sin(theta);
    } */

    /* Alternative constructor, using the enum above, to manage various cases
    Constructor is ugly. You need documentation, as below.
     */

    /**
     * @param a  is x if cartesian or rho if polar.
     * @param b  is y if cartesian or theta if polar.
     * @param cs is coordinate system, cartesian or polar.
     */
    private Point(double a, double b, CoordinateSystem cs) {
        switch (cs) {
            case CARTESIAN:
                this.x = x;
                this.y = y;
                break;
            case POLAR:
                x = a * Math.cos(b);
                y = a * Math.sin(b);
                break;
        }
    }

    @Override
    public String toString() {
        return String.format("Coord1: %.1f; Coord2: %.1f", x, y);
    }

    // Factory methods!
    public static Point newCartesianPoint(double x, double y) {
        return new Point(x, y);
    }

    public static Point newPolarPoint(double rho, double theta) {
        return new Point(
                rho * Math.cos(theta),
                rho * Math.sin(theta)
        );
    }
}


class Main {
    public static void main(String[] args) {
        // using a factory method
        Point cartesian = Point.newCartesianPoint(4, 2);
        Point polar = Point.newPolarPoint(5, 3);

        System.out.println(cartesian);
        System.out.println(polar);
    }
}