package info.md7.java.lessons.patterns.structural;

import info.md7.java.lessons.patterns.structural.decorator.example_1.Developer;
import info.md7.java.lessons.patterns.structural.decorator.example_1.SeniorPythonDeveloper;
import info.md7.java.lessons.patterns.structural.decorator.example_1.PythonDeveloper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DecoratorTest {

  @Test
  void decoratorTest() {
    Developer developer = new PythonDeveloper();
    Assertions.assertEquals("Writing code on Python", developer.writeCode());
    SeniorPythonDeveloper developer1 = new SeniorPythonDeveloper(developer);
    Assertions.assertEquals("Writing code on Python and reviewing code", developer1.writeCode());
  }

}
