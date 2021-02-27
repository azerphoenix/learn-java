package info.md7.java.lessons.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo extends Thread {

  private List<String> firstList = new ArrayList<>();

  private List<String> secondList = new ArrayList<>();

  private Lock lock1 = new ReentrantLock();

  private Lock lock2 = new ReentrantLock();

  public void firstMethod() {
    lock1.lock();
    try {
      Thread.sleep(1);
      firstList.add(UUID.randomUUID().toString());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally{
      lock1.unlock();
    }
  }

  public void secondMethod() {
    lock2.lock();
    try {
      Thread.sleep(1);
      secondList.add(UUID.randomUUID().toString());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally{
      lock2.unlock();
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
