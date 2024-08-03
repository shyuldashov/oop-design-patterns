package behavioral.interpreter;


/**
 * Uses Binary Tree approach.
 */
public class BinaryOperation implements Element {
    public enum Type {
        ADDITION,
        SUBTRACTION
    }

    public Type type;
    public Element left, right;

    @Override
    public int eval() {
        return switch (type) {
            case ADDITION -> left.eval() + right.eval();
            case SUBTRACTION -> left.eval() - right.eval();
            default -> 0;
        };
    }
}
