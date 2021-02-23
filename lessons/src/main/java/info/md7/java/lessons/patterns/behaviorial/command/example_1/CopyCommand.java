package info.md7.java.lessons.patterns.behaviorial.command.example_1;

public class CopyCommand extends Command{

  public CopyCommand() {
  }

  @Override
  public void execute() {
    System.out.println("Copy command button is pressed!");
  }

}
