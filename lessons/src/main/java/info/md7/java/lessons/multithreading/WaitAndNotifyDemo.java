package info.md7.java.lessons.multithreading;

import java.util.Scanner;

public class WaitAndNotifyDemo {

  public void producer() {
    synchronized (this) {
      System.out.println("Produce thread is running");
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Resumed");
    }
  }

  public void consumer() {
    Scanner scanner = new Scanner(System.in);
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    synchronized (this){
      System.out.println("Enter any key: ");
      scanner.nextLine();
      System.out.println("Key pressed");
      notify();
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
