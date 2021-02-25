package info.md7.java.lessons.patterns.behavioral.strategy.example_2;

public class NoFly implements Flyable {

  @Override
  public void fly() {
    System.out.println("No flying");
  }
}
