package info.md7.java.lessons.multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo implements Runnable {

  private CountDownLatch countDownLatch;

  public CountDownLatchDemo(CountDownLatch countDownLatch) {
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
    System.out.println("Thread started");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    countDownLatch.countDown();
  }
}
