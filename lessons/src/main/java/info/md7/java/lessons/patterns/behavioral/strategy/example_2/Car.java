package info.md7.java.lessons.patterns.behavioral.strategy.example_2;

public abstract class Car {

  private Flyable flyable;

  protected Car(Flyable flyable) {
    this.flyable = flyable;
  }

  abstract void run();

  public void stop() {
    System.out.println("Car stopped");
  }

  public void fly() {
    flyable.fly();
  }

}
