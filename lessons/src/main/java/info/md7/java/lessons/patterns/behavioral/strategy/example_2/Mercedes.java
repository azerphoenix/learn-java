package info.md7.java.lessons.patterns.behavioral.strategy.example_2;

public class Mercedes extends Car {

  public Mercedes(Flyable flyable) {
    super(flyable);
  }

  @Override
  void run() {
    System.out.println("Toyota is running");
  }
}
