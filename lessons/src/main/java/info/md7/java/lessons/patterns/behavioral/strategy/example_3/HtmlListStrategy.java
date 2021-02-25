package info.md7.java.lessons.patterns.behavioral.strategy.example_3;

public class HtmlListStrategy implements ListStrategy {
  @Override
  public void start(StringBuilder sb) {
    sb.append("<ul>").append(System.lineSeparator());
  }

  @Override
  public void addListItem(StringBuilder stringBuilder, String item) {
    stringBuilder.append("  <li>").append(item).append("</li>").append(System.lineSeparator());
  }

  @Override
  public void end(StringBuilder sb) {
    sb.append("</ul>").append(System.lineSeparator());
  }
}
