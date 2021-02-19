package info.md7.java.lessons.multithreading;

/*
  Runnable demo
 */
public class RunnableImpl implements Runnable {

  private int i = 0;

  public RunnableImpl(int i) {
    this.i = i;
  }

  @Override
  public void run() {
    doJob(i);

    // Thread yield()
    Thread.yield();

    // TimeUnit
    /*try {
      TimeUnit.MINUTES.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }*/

    // Thread sleep
    /*try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }*/
  }

  public void doJob(int i) {
    System.out.println("Hello World - " + i);
  }

}
