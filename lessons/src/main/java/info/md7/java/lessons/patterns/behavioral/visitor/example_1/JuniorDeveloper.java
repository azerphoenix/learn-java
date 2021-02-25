package info.md7.java.lessons.patterns.behavioral.visitor.example_1;

public class JuniorDeveloper implements Developer{

  @Override
  public void create(ProjectClass projectClass) {
    System.out.println("Coding simple project");
  }

  @Override
  public void create(Database database) {
    System.out.println("Connecting to Database");
  }

  @Override
  public void create(Test test) {
    System.out.println("Writing simple tests for project");
  }
}
