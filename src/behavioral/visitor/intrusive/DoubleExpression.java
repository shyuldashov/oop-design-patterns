package behavioral.visitor.intrusive;


public class DoubleExpression extends Expression {
    private double value;

    public DoubleExpression(double value) {
        this.value = value;
    }

    @Override
    public void print(StringBuilder stringBuilder) {
        stringBuilder.append(value);
    }
}
