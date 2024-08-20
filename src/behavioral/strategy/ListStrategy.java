package behavioral.strategy;


public interface ListStrategy {

    default void start(StringBuilder stringBuilder) {
    }

    void addListItem(StringBuilder stringBuilder, String string);

    default void end(StringBuilder stringBuilder) {
    }

}
