package info.md7.java.lessons.patterns.behavioral.strategy.example_3;

public interface ListStrategy {

  default void start(StringBuilder sb) {}
  void addListItem(StringBuilder stringBuilder, String item);
  default void end(StringBuilder sb) {}

}
