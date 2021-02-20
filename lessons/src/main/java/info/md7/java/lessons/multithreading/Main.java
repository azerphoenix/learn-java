package info.md7.java.lessons.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

  public static void main(String[] args) {
    multithreadingCallable();
    multithreadingRunnable();
  }

  /**
   * Multithreading via implementing Runnable
   */
  public static void multithreadingRunnable() {
    ExecutorService executorService = Executors.newCachedThreadPool();
    for (int i = 0; i <= 100; i++) {
      executorService.execute(new RunnableImpl(i));
    }
    executorService.shutdown();
  }

  /**
   * Multithreading via implementing Callable
   */
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
}
