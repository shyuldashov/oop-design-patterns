package behavioral.strategy;

import java.util.List;


public class TextProcessorDynamic {

    private StringBuilder stringBuilder = new StringBuilder();
    private ListStrategy listStrategy;

    public TextProcessorDynamic(OutputFormat outputFormat) {
        setOutputFormat(outputFormat);
    }

    public void setOutputFormat(OutputFormat format) {
        switch (format) {
            case MARKDOWN:
                listStrategy = new MarkdownListStrategy();
                break;
            case HTML:
                listStrategy = new HtmlListStrategy();
        }
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


class MainTwo {
    public static void main(String[] args) {
        TextProcessorDynamic textProcessorDynamic =
                new TextProcessorDynamic(OutputFormat.MARKDOWN);
        textProcessorDynamic.appendList(List.of("foo", "bar", "baz"));
        System.out.println(textProcessorDynamic);

        // --------------------

        textProcessorDynamic.clear();
        textProcessorDynamic.setOutputFormat(OutputFormat.HTML);
        textProcessorDynamic.appendList(List.of("go", "lua", "java", "python"));
        System.out.println(textProcessorDynamic);
    }

}
