package info.md7.java.lessons.patterns.behavioral.command.example_1;

public class Button {

  public void pressButton(Command command) {
    command.execute();
  }
}
