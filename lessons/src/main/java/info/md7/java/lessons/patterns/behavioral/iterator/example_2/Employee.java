package info.md7.java.lessons.patterns.behavioral.iterator.example_2;

import java.util.Iterator;
import java.util.List;

public class Employee implements Iterable<String>{

  private List<String> skills;

  public Employee(List<String> skills) {
    this.skills = skills;
  }

  @Override
  public Iterator<String> iterator() {
    return skills.iterator();
  }

}
