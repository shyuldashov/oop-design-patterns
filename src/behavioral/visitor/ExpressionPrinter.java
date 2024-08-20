package behavioral.visitor;


public class ExpressionPrinter implements ExpressionVisitor {

    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void visit(DoubleExpression expression) {
        stringBuilder.append(expression.value);
    }

    @Override
    public void visit(AdditionExpression expression) {
        stringBuilder.append("(");
        expression.left.accept(this);
        stringBuilder.append("+");
        expression.right.accept(this);
        stringBuilder.append(")");
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
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

        ExpressionPrinter expressionPrinter = new ExpressionPrinter();
        expressionPrinter.visit(expression);
        System.out.println(expressionPrinter);

        // --------------------

        ExpressionCalculator expressionCalculator = new ExpressionCalculator();
        expressionCalculator.visit(expression);
        System.out.printf("%s = %.2f%n", expressionPrinter, expressionCalculator.result);
    }
}
