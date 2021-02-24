package info.md7.java.lessons.patterns.behavioral.memento.example_1;

import java.time.LocalDate;

public class Save {

  private final String version;
  private final LocalDate date;

  public Save(String version) {
    this.version = version;
    date = LocalDate.now();
  }

  public String getVersion() {
    return version;
  }

  public LocalDate getDate() {
    return date;
  }
}
