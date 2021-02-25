package info.md7.java.lessons.patterns.behavioral.strategy.example_3;

public class MarkdownListStrategy implements ListStrategy {
  @Override
  public void addListItem(StringBuilder stringBuilder, String item) {
    stringBuilder.append(" * ").append(item).append(System.lineSeparator());
  }
}
