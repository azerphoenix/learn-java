package info.md7.java.lessons.patterns.behavioral.visitor.example_2;

public class SoundVIsitor implements AnimalVisitor{

  @Override
  public void action(Dog dog) {
    System.out.println("Bark");
  }

  @Override
  public void action(Cat cat) {
    System.out.println("Meow");
  }
}
