package info.md7.java.homeworks.hw_7.workbook.pojo;

import java.time.LocalDateTime;
import java.util.Map;

public class Subject {

  private String name;
  private Map<LocalDateTime, Integer> marks;

  public Subject() {}

  public Subject(String name, Map<LocalDateTime, Integer> marks) {
    this.name = name;
    this.marks = marks;
  }

  /**
   * Метод для выставления новой оценки по выбранному предмету для студента
   * @param mark
   */
  public void addNewMark(int mark) {
    marks.put(LocalDateTime.now(), mark);
  }

  /**
   * Распечатать все оценки по данному предмету
   */
  public void printAllMarks() {
    marks.forEach(
        (key, value) -> System.out.println("Дата выставления: " + key + " " + "Оценка: " + value));
  }

  /**
   * Метод для удаления неудовлетворительных оценок для выбранного предмета
   */
  public void removeAllUnsatisfactoryGrades() {
    marks.entrySet().removeIf(entry -> (entry.getValue().equals(2)));
  }

  /**
   * Метод распечатывает высокую оценку для выбранного студента
   */
  public void printAllGoodGrades() {
    marks.forEach((key, value) -> {
      if (value.equals(5)) {
        System.out.println("Дата выставления: " + key + " " + "Оценка: " + value);
      }
    });
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Map<LocalDateTime, Integer> getMarks() {
    return marks;
  }

  public void setMarks(Map<LocalDateTime, Integer> marks) {
    this.marks = marks;
  }

  @Override
  public String toString() {
    return "Предмет{" +
        "Название='" + name + '\'' +
        ", Оценки=" + marks +
        '}';
  }

}
