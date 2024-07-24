package creational.prototype;


public class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("Point(x=%d, y=%d)", x, y);
    }
}


class Line {
    public Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line deepCopy() {
        return new Line(
                new Point(start.x, start.y),
                new Point(end.x, end.y)
        );
    }

    @Override
    public String toString() {
        return String.format("Line(start=%s, end=%s)\n", start, end);
    }
}


class MainThree {
    public static void main(String[] args) {
        Line line1 = new Line(
                new Point(3, 2),
                new Point(4, 6)

        );

        Line line2 = line1.deepCopy();
        System.out.printf("Before changes\n%s%s", line1, line2);

        // Changing coordinates for line2
        line2.start.x = 15;
        line2.start.y = 30;

        line2.end.x = 10;
        line2.end.y = 20;

        System.out.printf("\nAfter changes\n%s%s", line1, line2);
    }
}


