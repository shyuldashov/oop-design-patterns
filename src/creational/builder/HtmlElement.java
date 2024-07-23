package creational.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HtmlElement {
    private static final int indentSize = 2;
    public String name, text;
    public List<HtmlElement> elements = new ArrayList<>();

    public HtmlElement() {
    }

    public HtmlElement(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public static HtmlBuilder create(String name) {
        return new HtmlBuilder(name);
    }

    private String getIndent(int currentIndentSize) {
        return String.join(
                "", Collections.nCopies(currentIndentSize * indentSize, " ")
        );
    }

    private String toStringRecursive(int currentIndentSize) {
        StringBuilder sb = new StringBuilder();
        String currentIndent = getIndent(currentIndentSize);
        sb.append(String.format("%s<%s>\n", currentIndent, name));

        if (text != null && !text.isEmpty()) {
            String tempIndent = getIndent(currentIndentSize + 1);
            sb.append(String.format("%s%s\n", tempIndent, text));
        }
        for (HtmlElement element : elements) {
            sb.append(element.toStringRecursive(currentIndentSize + 1));
        }
        sb.append(String.format("%s</%s>\n", currentIndent, name));
        return sb.toString();
    }

    @Override
    public String toString() {
        return toStringRecursive(0);
    }
}


class MainTwo {
    public static void main(String[] args) {
        // Simple HTML paragraph using a list
        String hello = "Hello";
        String[] parts = {"<p>", hello, "</p>"};
        System.out.println(String.join("", parts));

        String[] words = {"Hello", "World"};
        List<String> listParts = new ArrayList<>();
        listParts.add("<ul>");
        for (String word : words) {
            listParts.add(String.format("  <li>%s</li>", word));
        }
        listParts.add("</ul>");
        System.out.println(String.join("\n", listParts));

        // --------------------

        // Ordinary non-fluent builder
        HtmlBuilder builder = HtmlElement.create("ul");
        builder.addChild("li", "Hello");
        builder.addChild("li", "World");
        System.out.println("Ordinary builder:");
        System.out.println(builder);

        // Fluent builder
        builder.clear();
        builder.addChildFluent("li", "Hello")
                .addChildFluent("li", "World");
        System.out.println("Fluent builder:");
        System.out.println(builder);
    }
}