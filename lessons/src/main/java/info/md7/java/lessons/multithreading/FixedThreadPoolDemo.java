package info.md7.java.lessons.multithreading;

public class FixedThreadPoolDemo implements Runnable {

  private int num;

  public FixedThreadPoolDemo(int num) {
    this.num = num;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.printf("Current num is: %s %s", num, System.lineSeparator());
  }


}
