package info.md7.java.lessons.multithreading;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {

  private int count = 0;

  private Lock lock = new ReentrantLock();

  private Condition condition = lock.newCondition();

  private void increment() {
    for (int i = 0; i < 1000; i++) {
      count++;
    }
  }

  public void firstMethod() throws InterruptedException {
    lock.lock();
    System.out.println("Waiting ...");
    condition.await();
    System.out.println("Working");
    try {
      increment();
    } finally{
      lock.unlock();
    }
  }

  public void secondMethod() throws InterruptedException {
    Thread.sleep(3000);
    lock.lock();
    System.out.println("Press any key");
    new Scanner(System.in).nextLine();
    System.out.println("Key pressed");
    condition.signal();
    try {
      increment();
    } finally{
      lock.unlock();
    }
  }

  public void finished() {
    System.out.printf("Count is: %s ", count);
  }

}
