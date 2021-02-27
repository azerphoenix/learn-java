package info.md7.java.lessons.multithreading;

public class ThreadDemo extends Thread {

  @Override
  public void run() {
    for (int i = 0; i <= 50; i++) {
      System.out.printf("Number: %s %s", i, System.lineSeparator());
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
