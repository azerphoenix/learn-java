package info.md7.java.lessons.multithreading;

public class VolatileDemo extends Thread {

  private volatile boolean running = true;

  @Override
  public void run() {
    while (running) {
      System.out.println("Test");
      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void shutdown() {
    running = false;
  }
}
