package info.md7.java.lessons.patterns.behavioral;

import info.md7.java.lessons.patterns.behavioral.iterator.example_1.Iterator;
import info.md7.java.lessons.patterns.behavioral.iterator.example_1.User;
import info.md7.java.lessons.patterns.behavioral.iterator.example_2.Employee;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IteratorTest {

  @Test
  void iteratorTest() {
    String[] skills = {"Java", "Python", "WordPress", "Django", "Spring"};
    User user = new User(skills);
    Iterator iterator = user.getIterator();
    while (iterator.hasNext()) {
      Assertions.assertNotNull(iterator.next());
    }
    List<String> employeeSkills = List.of(skills);
    Employee employee = new Employee(employeeSkills);
    for (String skill : employee) {
      Assertions.assertNotNull(skill);
    }
  }

}
