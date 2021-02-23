package info.md7.java.lessons.patterns.behaviorial.command.example_1;

public class CutCommand extends Command {

  public CutCommand() {
  }

  @Override
  public void execute() {
    System.out.println("Cut command button is pressed!");
  }

}
