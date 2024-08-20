package behavioral.strategy;

import java.util.List;
import java.util.function.Supplier;


public class TextProcessorStatic<LS extends ListStrategy> {

    private StringBuilder stringBuilder = new StringBuilder();
    private LS listStrategy;

    public TextProcessorStatic(Supplier<? extends LS> supplier) {
        listStrategy = supplier.get();
    }

    public void appendList(List<String> items) {
        listStrategy.start(stringBuilder);
        for (String item : items) {
            listStrategy.addListItem(stringBuilder, item);
        }
        listStrategy.end(stringBuilder);
    }

    public void clear() {
        stringBuilder.setLength(0);
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }

}


class Main {
    public static void main(String[] args) {
        TextProcessorStatic<MarkdownListStrategy> textProcessorStatic
                = new TextProcessorStatic<>(MarkdownListStrategy::new);
        textProcessorStatic.appendList(List.of("foo", "bar", "baz"));
        System.out.println(textProcessorStatic);

        // --------------------

        TextProcessorStatic<HtmlListStrategy> textProcessorStatic2
                = new TextProcessorStatic<>(HtmlListStrategy::new);
        textProcessorStatic2.appendList(List.of("one", "two", "three"));
        System.out.println(textProcessorStatic2);
    }
}
