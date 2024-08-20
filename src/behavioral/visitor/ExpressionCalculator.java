package behavioral.visitor;


public class ExpressionCalculator implements ExpressionVisitor {
    public double result;

    @Override
    public void visit(DoubleExpression expression) {
        result = expression.value;
    }

    @Override
    public void visit(AdditionExpression expression) {
        expression.left.accept(this);
        double cache = result;
        expression.right.accept(this);
        double cache2 = result;
        result = cache + cache2;
    }
}
