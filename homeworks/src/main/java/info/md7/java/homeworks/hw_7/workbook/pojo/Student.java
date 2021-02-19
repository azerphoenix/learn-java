package info.md7.java.homeworks.hw_7.workbook.pojo;

import java.util.List;

public class Student {

  private String name;
  private List<Subject> subjects;

  public Student() {}

  public Student(String name, List<Subject> subjects) {
    this.name = name;
    this.subjects = subjects;
  }

  /**
   * Метод для добавления нового предмета в список предметов студента
   * @param subject
   */
  public void addNewSubject(Subject subject) {
    subjects.add(subject);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Subject> getSubjects() {
    return subjects;
  }

  public void setSubjects(List<Subject> subjects) {
    this.subjects = subjects;
  }

  @Override
  public String toString() {
    return "Студент{" +
        "ФИО: '" + name + '\'' +
        ", Изучаемые предметы: " + subjects +
        '}';
  }

}
