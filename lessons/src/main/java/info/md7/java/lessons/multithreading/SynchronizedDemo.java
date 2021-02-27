package info.md7.java.lessons.multithreading;

public class SynchronizedDemo {

  private static int count = 0;

  public static void doJob() {
    Thread thread1 = new Thread(() -> {
      for (int i = 0; i < 1000; i++) {
        increment();
      }
    });
    Thread thread2 = new Thread(() -> {
      for (int i = 0; i < 1000; i++) {
        increment();
      }
    });
    thread1.start();
    thread2.start();
    try {
      thread1.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    try {
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.printf("Count is: %s", count);
  }

  public static synchronized void increment() {
    count++;
  }

}
