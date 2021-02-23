package info.md7.java.lessons.patterns.behavioral;

import info.md7.java.lessons.patterns.behavioral.interpreter.example_1.Expression;
import info.md7.java.lessons.patterns.behavioral.interpreter.example_1.Runner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InterpreterTest {

  @Test
  void interpreterTest() {
    Expression isJavaDeveloper = Runner.getJavaExpression();
    Expression isJavaEEDeveloper = Runner.getJavaEEExpression();
    Assertions.assertTrue(isJavaDeveloper.interpret("Java"));
    Assertions.assertTrue(isJavaEEDeveloper.interpret("Java Spring"));
  }

}
