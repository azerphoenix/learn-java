package info.md7.java.homeworks.hw_7.task;


import info.md7.java.homeworks.hw_7.task.pojo.Pupil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingClass {

  public void printPupils() {
    List<Pupil> pupils = new ArrayList<>();
    pupils.add(new Pupil("Иван", 2, 20));
    pupils.add(new Pupil("Александр", 5, 22));
    pupils.add(new Pupil("Анастасия", 4, 21));
    pupils.add(new Pupil("Василий", 4, 30));
    pupils.add(new Pupil("Владимир", 3, 19));
    pupils.add(new Pupil("Екатерина", 3,  27));
    pupils.add(new Pupil("Валерия", 5,  28));
    pupils.add(new Pupil("Марина", 5,  20));
    pupils.add(new Pupil("Лилия", 2, 23));
    pupils.add(new Pupil("Николай", 4,  35));
    pupils.add(new Pupil("Игорь", 4, 18));
    pupils.add(new Pupil("Роман", 5, 18));

    System.out.println("Сортируем учеников по имени: ");
    Collections.sort(pupils, Pupil.PupilNameComparator);
    pupils.forEach(System.out::println);

    System.out.println("Сортируем учеников по возрасту: ");
    Collections.sort(pupils, Pupil.PupilAgeComparator);
    pupils.forEach(System.out::println);

    System.out.println("Сортируем учеников по оценке: ");
    Collections.sort(pupils, Pupil.PupilMarksComparator);
    pupils.forEach(System.out::println);
  }

}
