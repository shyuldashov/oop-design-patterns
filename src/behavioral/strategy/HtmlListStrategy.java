package behavioral.strategy;


public class HtmlListStrategy implements ListStrategy {

    @Override
    public void start(StringBuilder stringBuilder) {
        stringBuilder.append("<ul>").append(System.lineSeparator());
    }

    @Override
    public void addListItem(StringBuilder stringBuilder, String string) {
        stringBuilder.append("\t<li>")
                .append(string)
                .append("</li>")
                .append(System.lineSeparator());
    }

    @Override
    public void end(StringBuilder stringBuilder) {
        stringBuilder.append("</ul>").append(System.lineSeparator());
    }
}
