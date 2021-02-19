package info.md7.java.homeworks.hw_7.task.pojo;

import java.util.Comparator;

public class Pupil implements Comparable<Pupil>{

  private String name;
  private int mark;
  private int age;

  public Pupil() {}

  public Pupil(String name, int mark, int age) {
    this.name = name;
    this.mark = mark;
    this.age = age;
  }

  @Override
  public int compareTo(Pupil o) {
    return this.name.compareTo(o.name);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getMark() {
    return mark;
  }

  public void setMark(int mark) {
    this.mark = mark;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Ученик{" +
        "ФИО: '" + name + '\'' +
        ", Оценка: " + mark +
        ", Возраст: " + age +
        '}';
  }

  /**
   * Класс Comparator для сравнения Pupil по названию
   */
  public static Comparator<Pupil> PupilNameComparator = new Comparator<Pupil>() {

    @Override
    public int compare(Pupil o1, Pupil o2) {
      String pupilName1 = o1.getName().toUpperCase();
      String pupilName2 = o2.getName().toUpperCase();
      return pupilName1.compareTo(pupilName2);
    }

  };

  /**
   * Класс Comparator для сравнения Pupil по возрасту
   */
  public static Comparator<Pupil> PupilAgeComparator = new Comparator<Pupil>() {

    @Override
    public int compare(Pupil o1, Pupil o2) {
      int pupilAge1 = o1.getAge();
      int pupilAge2 = o2.getAge();
      return pupilAge1 - pupilAge2;
    }

  };

  /**
   * Класс Comparator для сравнения Pupil по оценке
   */
  public static Comparator<Pupil> PupilMarksComparator = new Comparator<Pupil>() {

    @Override
    public int compare(Pupil o1, Pupil o2) {
      int pupilMark1 = o1.getMark();
      int pupilMark2 = o2.getMark();
      return pupilMark1 - pupilMark2;
    }

  };

}
