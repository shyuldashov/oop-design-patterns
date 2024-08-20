package behavioral.visitor.reflective;


public class ReflectiveExpressionPrinter {

    public static void print(Expression expression, StringBuilder stringBuilder) {
        if (expression.getClass() == DoubleExpression.class) {
            stringBuilder.append(((DoubleExpression) expression).value);
        } else if (expression.getClass() == AdditionExpression.class) {
            AdditionExpression additionExpression = (AdditionExpression) expression;
            stringBuilder.append("(");
            print(additionExpression.left, stringBuilder);
            stringBuilder.append("+");
            print(additionExpression.right, stringBuilder);
            stringBuilder.append(")");
        }
    }
}


class Main {
    public static void main(String[] args) {
        AdditionExpression expression = new AdditionExpression(
                new DoubleExpression(2),
                new AdditionExpression(
                        new DoubleExpression(3),
                        new DoubleExpression(4)
                )
        );

        StringBuilder stringBuilder = new StringBuilder();
        ReflectiveExpressionPrinter.print(expression, stringBuilder);
        System.out.println(stringBuilder);
    }
}
