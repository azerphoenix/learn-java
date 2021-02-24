package info.md7.java.lessons.patterns.behavioral.memento.example_1;

import java.time.LocalDate;

public class Project {

  private String version;
  private LocalDate date;

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
    this.date = date.now();
  }

  public Save save() {
    return new Save(version);
  }

  public void load(Save save) {
    version = save.getVersion();
    date = save.getDate();
  }


  @Override
  public String toString() {
    return "Project{" +
        "version='" + version + '\'' +
        ", date=" + date +
        '}';
  }
}
