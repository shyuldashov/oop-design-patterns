package behavioral.visitor.intrusive;

public class Intrusive {
    public static void main(String[] args) {
        AdditionExpression expression = new AdditionExpression(
                new DoubleExpression(2),
                new AdditionExpression(
                        new DoubleExpression(3),
                        new DoubleExpression(4)
                )
        );

        StringBuilder stringBuilder = new StringBuilder();
        expression.print(stringBuilder);
        System.out.println(stringBuilder);
    }
}
