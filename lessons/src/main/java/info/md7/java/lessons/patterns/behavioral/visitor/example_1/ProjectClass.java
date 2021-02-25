package info.md7.java.lessons.patterns.behavioral.visitor.example_1;

public class ProjectClass implements ProjectElement {

  @Override
  public void beWritten(Developer developer) {
    developer.create(this);
  }

}
