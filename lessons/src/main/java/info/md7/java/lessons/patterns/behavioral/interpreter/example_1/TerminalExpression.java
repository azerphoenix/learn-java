package info.md7.java.lessons.patterns.behavioral.interpreter.example_1;

public class TerminalExpression implements Expression {

  private String data;

  public TerminalExpression(String data) {
    this.data = data;
  }

  @Override
  public boolean interpret(String str) {
    if (str.contains(data)){
      return true;
    }
    return false;
  }
}
