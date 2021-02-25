package info.md7.java.lessons.patterns.behavioral.visitor.example_2;

public class EatVisitor implements AnimalVisitor {

  @Override
  public void action(Dog dog) {
    System.out.println("Meat");
  }

  @Override
  public void action(Cat cat) {
    System.out.println("Fish");
  }
}
