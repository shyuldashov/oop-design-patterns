package behavioral.visitor;


public interface ExpressionVisitor {

    void visit(DoubleExpression doubleExpression);

    void visit(AdditionExpression additionExpression);
}
