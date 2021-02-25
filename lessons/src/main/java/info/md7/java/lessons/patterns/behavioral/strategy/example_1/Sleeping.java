package info.md7.java.lessons.patterns.behavioral.strategy.example_1;

public class Sleeping implements Activity {

  @Override
  public void doSomething() {
    System.out.println("Developer is sleeping");
  }
}
