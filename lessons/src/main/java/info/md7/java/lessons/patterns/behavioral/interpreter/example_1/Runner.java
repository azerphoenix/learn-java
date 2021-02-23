package info.md7.java.lessons.patterns.behavioral.interpreter.example_1;

public class Runner {

  public static Expression getJavaExpression() {
    Expression java = new TerminalExpression("Java");
    Expression javaCore = new TerminalExpression("Java Core");
    return new OrExpression(java, javaCore);
  }

  public static Expression getJavaEEExpression() {
    Expression java = new TerminalExpression("Java");
    Expression spring = new TerminalExpression("Spring");
    return new AndExpression(java, spring);
  }

}
