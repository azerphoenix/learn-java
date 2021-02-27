package info.md7.java.lessons.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SynchronizedBlockDemo extends Thread {

  private List<String> firstList = new ArrayList<>();

  private List<String> secondList = new ArrayList<>();

  private Object lock1 = new Object();

  private Object lock2 = new Object();

  public void firstMethod() {
    synchronized (lock1) {
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      firstList.add(UUID.randomUUID().toString());
    }
  }

  public void secondMethod() {
    synchronized (lock2) {
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      secondList.add(UUID.randomUUID().toString());
    }
  }

  public void process() {
    for (int i = 0; i < 1000; i++) {
      firstMethod();
      secondMethod();
    }
  }

  @Override
  public void run() {
    process();
  }

  public List<String> getFirstList() {
    return firstList;
  }

  public List<String> getSecondList() {
    return secondList;
  }
}
