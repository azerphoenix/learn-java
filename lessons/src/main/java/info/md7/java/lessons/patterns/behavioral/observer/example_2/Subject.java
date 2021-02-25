package info.md7.java.lessons.patterns.behavioral.observer.example_2;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class Subject extends Observable {

  @Override
  public synchronized void setChanged() {
    super.setChanged();
  }
}
