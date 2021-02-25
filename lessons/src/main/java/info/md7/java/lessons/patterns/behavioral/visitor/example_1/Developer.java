package info.md7.java.lessons.patterns.behavioral.visitor.example_1;

public interface Developer {

  void create(ProjectClass projectClass);
  void create(Database database);
  void create(Test test);

}
