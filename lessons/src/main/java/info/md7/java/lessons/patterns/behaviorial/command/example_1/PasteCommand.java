package info.md7.java.lessons.patterns.behaviorial.command.example_1;

public class PasteCommand extends Command{

  public PasteCommand() {
  }

  @Override
  public void execute() {
    System.out.println("Paste command button is pressed!");
  }

}
