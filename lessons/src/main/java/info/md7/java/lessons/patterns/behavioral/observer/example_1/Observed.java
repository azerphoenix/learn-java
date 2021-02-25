package info.md7.java.lessons.patterns.behavioral.observer.example_1;

public interface Observed {

  void addObserver(Observer observer);

  void removeObserver(Observer observer);

  void notifyObservers();

}
