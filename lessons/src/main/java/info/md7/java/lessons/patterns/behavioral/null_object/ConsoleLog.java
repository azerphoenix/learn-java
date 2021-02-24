package info.md7.java.lessons.patterns.behavioral.null_object;

public class ConsoleLog implements Log {

  @Override
  public void info(String msg) {
    System.out.println(msg);
  }

  @Override
  public void warn(String msg) {
    System.out.println(msg);
  }

  @Override
  public void debug(String msg) {
    System.out.println(msg);
  }
}
