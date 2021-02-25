package info.md7.java.lessons.patterns.behavioral.observer.example_1;

import java.util.List;

public class Subscriber implements Observer {

  private String name;

  public Subscriber(String name) {
    this.name = name;
  }

  @Override
  public void handleEvent(List<String> vacancies) {
    System.out.printf("%s you have new unwatched vacancies - %s. %s", name, vacancies, System.lineSeparator());
  }

}
