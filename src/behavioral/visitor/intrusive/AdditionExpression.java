package behavioral.visitor.intrusive;

public class AdditionExpression extends Expression {
    private Expression left, right;

    public AdditionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void print(StringBuilder stringBuilder) {
        stringBuilder.append("(");
        left.print(stringBuilder);
        stringBuilder.append("+");
        right.print(stringBuilder);
        stringBuilder.append(")");
    }
}
