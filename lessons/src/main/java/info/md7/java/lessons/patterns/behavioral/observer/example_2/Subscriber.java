package info.md7.java.lessons.patterns.behavioral.observer.example_2;


import java.util.Observable;
import java.util.Observer;


@SuppressWarnings("deprecation")
public class Subscriber implements Observer {

  @Override
  public void update(Observable o, Object arg) {
    System.out.println("Hello World");
  }

}
