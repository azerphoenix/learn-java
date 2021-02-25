package info.md7.java.lessons.patterns.behavioral.visitor.example_2;

public class Dog implements Animal {

  @Override
  public void accept(AnimalVisitor animalVisitor) {
    animalVisitor.action(this);
  }

}
