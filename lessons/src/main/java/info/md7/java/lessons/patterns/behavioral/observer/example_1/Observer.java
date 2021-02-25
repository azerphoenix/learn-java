package info.md7.java.lessons.patterns.behavioral.observer.example_1;

import java.util.List;

public interface Observer {
  
  void handleEvent(List<String> vacancies);

}
