package info.md7.java.lessons.patterns.structural.adapter;

public class AnotherDatasource {

  public String save() {
    return "New object was created!";
  }

  public String get() {
    return "Retrieving selected object";
  }

  public String change() {
    return "Updating selected object";
  }

  public String remove() {
    return "Deleting selected object";
  }

}
