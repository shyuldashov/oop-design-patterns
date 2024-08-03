package behavioral.interpreter;


public class Token {
    public enum Type {
        INTEGER,
        PLUS,
        MINUS,
        LPAREN,
        RPAREN
    }

    public Type type; // Type of token being valued
    public String text; // Text value of the token

    public Token(Type type, String text) {
        this.type = type;
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("`%s`", text);
    }
}
