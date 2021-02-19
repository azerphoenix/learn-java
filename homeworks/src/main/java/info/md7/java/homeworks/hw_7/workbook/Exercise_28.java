package info.md7.java.homeworks.hw_7.workbook;

import info.md7.java.homeworks.hw_7.workbook.pojo.Student;
import info.md7.java.homeworks.hw_7.workbook.pojo.Subject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Exercise_28 {

  public static void main(String[] args) {
    List<Subject> subjects = Arrays.asList(
        new Subject("Algebra", new HashMap<>()),
        new Subject("Literature", new HashMap<>()),
        new Subject("English language", new HashMap<>())
    );

    List<Student> students = new ArrayList<>();
    Student johnSmith = new Student("John Smith", subjects);
    Student janeFonda = new Student("Jane Fonda", subjects);
    Student tomSilver = new Student("Tom Silver", subjects);
    students.add(johnSmith);
    students.add(janeFonda);
    students.add(tomSilver);

    for (Student student : students) {
      for (Subject subject : student.getSubjects()) {
        subject.addNewMark(2);
        subject.addNewMark(3);
        subject.addNewMark(5);
        subject.addNewMark(2);
        subject.addNewMark(2);
        subject.addNewMark(2);
        subject.addNewMark(5);
        subject.addNewMark(4);
      }
    }

    for (Student student : students) {
      System.out.println("ФИО студента: " + student.getName());
      Iterator<Subject> iterator = student.getSubjects().iterator();
      while (iterator.hasNext()){
        iterator.next().printAllGoodGrades();
      }
    }

  }

}
