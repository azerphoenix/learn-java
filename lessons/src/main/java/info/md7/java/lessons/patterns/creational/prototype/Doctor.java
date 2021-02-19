package info.md7.java.lessons.patterns.creational.prototype;

import java.io.Serializable;

/**
 * Prototype via serialization
 */
public class Doctor implements Serializable {

  private String name;

  private String surname;

  public Doctor() {}

  public Doctor(String name, String surname) {
    this.name = name;
    this.surname = surname;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }
}
