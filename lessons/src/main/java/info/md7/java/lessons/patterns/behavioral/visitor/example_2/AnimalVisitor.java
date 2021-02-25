package info.md7.java.lessons.patterns.behavioral.visitor.example_2;

public interface AnimalVisitor {

  void action(Dog dog);
  void action(Cat cat);

}
