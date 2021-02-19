package info.md7.java.lessons.multithreading;

import java.util.UUID;
import java.util.concurrent.Callable;

/*
  Callable demo
 */
public class CallableImpl implements Callable<String> {

  @Override
  public String call() throws Exception {
    return UUID.randomUUID().toString();
  }

}
