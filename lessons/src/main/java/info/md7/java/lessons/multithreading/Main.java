package info.md7.java.lessons.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {

  public static void main(String[] args) {
    fixedThreadPoolDemo();
  }

  /** Multithreading via extending Thread */
  public static void multithreadingThread() {
    ThreadDemo threadDemo1 = new ThreadDemo();
    threadDemo1.start();
    ThreadDemo threadDemo2 = new ThreadDemo();
    threadDemo2.start();
  }

  /** Volatile demo */
  public static void volatileDemo() {
    VolatileDemo volatileDemo = new VolatileDemo();
    volatileDemo.start();

    System.out.println("Press any key to stop");
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
    volatileDemo.shutdown();
  }

  /** Synchronized method demo */
  public static void synchronizedDemo() {
    SynchronizedDemo.doJob();
  }

  /** Multiple lock demo Critical section */
  public static void multipleLocksDemo() {
    long start = System.currentTimeMillis();
    SynchronizedBlockDemo synchronizedBlockDemo = new SynchronizedBlockDemo();
    synchronizedBlockDemo.start();
    try {
      synchronizedBlockDemo.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    long end = System.currentTimeMillis();
    System.out.printf("Time interval: %s %s", (end - start), System.lineSeparator());
    System.out.printf(
        "First list size: %s | Second list size: %s ",
        synchronizedBlockDemo.getFirstList().size(), synchronizedBlockDemo.getSecondList().size());
  }

  /**
   * Multiple lock demo using Reentrant lock
   */
  public static void multipleLocksDemoWithReentrantLock() {
    long start = System.currentTimeMillis();
    ReentrantLockDemo multipleLockDemo = new ReentrantLockDemo();
    multipleLockDemo.start();
    try {
      multipleLockDemo.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    long end = System.currentTimeMillis();
    System.out.printf("Time interval: %s %s", (end - start), System.lineSeparator());
    System.out.printf(
        "First list size: %s | Second list size: %s ",
        multipleLockDemo.getFirstList().size(), multipleLockDemo.getSecondList().size());
  }

  /** Multithreading via implementing Runnable ExecutorService */
  public static void multithreadingSimpleRunnable() {
    for (int i = 0; i <= 50; i++) {
      Thread thread = new Thread(new RunnableImpl(i));
      thread.start();
    }
  }

  /** Multithreading via implementing Runnable ExecutorService */
  public static void multithreadingRunnable() {
    ExecutorService executorService = Executors.newCachedThreadPool();
    for (int i = 0; i <= 100; i++) {
      executorService.execute(new RunnableImpl(i));
    }
    executorService.shutdown();
  }

  /** Multithreading via implementing Callable ExecutorService */
  public static void multithreadingCallable() {
    ExecutorService executorService = Executors.newCachedThreadPool();
    List<Future<String>> futureList = new ArrayList<>();
    for (int i = 0; i <= 100; i++) {
      Future<String> a = executorService.submit(new CallableImpl());
      futureList.add(a);
    }
    executorService.shutdown();
    for (Future<String> future : futureList) {
      try {
        System.out.println(future.get());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Thread Pools
   * Fixed Thread Pool
   */
  public static void fixedThreadPoolDemo() {
    long start = System.currentTimeMillis();
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    for(int i = 0; i < 100; i++) {
      executorService.submit(new FixedThreadPoolDemo(i));
    }
    executorService.shutdown();
    long end = System.currentTimeMillis();
    long result = end - start;
    try{
      executorService.awaitTermination(1, TimeUnit.HOURS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.printf("First service run time: %s %s", result, System.lineSeparator());
  }
}
