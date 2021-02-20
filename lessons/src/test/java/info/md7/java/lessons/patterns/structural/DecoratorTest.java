package info.md7.java.lessons.patterns.structural;

import info.md7.java.lessons.patterns.structural.decorator.Developer;
import info.md7.java.lessons.patterns.structural.decorator.SeniorPythonDeveloper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DecoratorTest {

  @Test
  void decoratorTest() {
    Developer developer = new info.md7.java.lessons.patterns.structural.decorator.PythonDeveloper();
    Assertions.assertEquals("Writing code on Python", developer.writeCode());
    SeniorPythonDeveloper developer1 = new SeniorPythonDeveloper(developer);
    Assertions.assertEquals("Writing code on Python and reviewing code", developer1.writeCode());
  }

}
