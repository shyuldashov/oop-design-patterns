package behavioral.strategy;


public class MarkdownListStrategy implements ListStrategy {

    @Override
    public void addListItem(StringBuilder stringBuilder, String string) {
        stringBuilder.append(" * ")
                .append(string)
                .append(System.lineSeparator());
    }
}
