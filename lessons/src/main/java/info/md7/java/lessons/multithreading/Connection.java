package info.md7.java.lessons.multithreading;

import java.util.concurrent.Semaphore;

public class Connection {

  private static final Connection INSTANCE = new Connection();

  private int connectionsCount = 0;

  private Semaphore semaphore = new Semaphore(10);

  private Connection(){}

  public static Connection getInstance() {
    return INSTANCE;
  }

  public void connect() {
    try {
      semaphore.acquire();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    try{
      doConnect();
    } finally{
      semaphore.release();
    }
  }

  public void doConnect() {
    synchronized (this) {
      connectionsCount++;
      System.out.printf("Connections: %s %s", connectionsCount, System.lineSeparator());
    }
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    synchronized (this) {
      connectionsCount--;
    }
  }

}
