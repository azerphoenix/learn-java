package info.md7.java.lessons.patterns.creational.singleton;

public class MonoState {

  private static String name;

  private static String surname;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    MonoState.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    MonoState.surname = surname;
  }

}
