package info.md7.java.lessons.patterns.behavioral.visitor.example_1;

public class SeniorDeveloper implements Developer {

  @Override
  public void create(ProjectClass projectClass) {
    System.out.println("Writing project and reviewing juniors code");
  }

  @Override
  public void create(Database database) {
    System.out.println("Creating database and updating it");
  }

  @Override
  public void create(Test test) {
    System.out.println("Writing unit test for project");
  }
}
