package info.md7.java.lessons.patterns.behavioral.interpreter.example_1;

public class OrExpression implements Expression {

  private Expression expression1;
  private Expression expression2;

  public OrExpression(Expression expression1,
      Expression expression2) {
    this.expression1 = expression1;
    this.expression2 = expression2;
  }

  @Override
  public boolean interpret(String str) {
    return expression1.interpret(str) || expression2.interpret(str);
  }
}
