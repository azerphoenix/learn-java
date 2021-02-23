package info.md7.java.lessons.patterns.structural.decorator.example_1;

public class SeniorPythonDeveloper extends DeveloperDecorator {

  public SeniorPythonDeveloper(Developer developer) {
    super(developer);
  }

  public String reviewCode() {
    return "reviewing code";
  }

  @Override
  public String writeCode() {
    return super.writeCode() + " and " + reviewCode();
  }
}
