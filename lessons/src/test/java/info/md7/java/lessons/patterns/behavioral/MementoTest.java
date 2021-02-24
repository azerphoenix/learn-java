package info.md7.java.lessons.patterns.behavioral;

import info.md7.java.lessons.patterns.behavioral.memento.example_1.Project;
import info.md7.java.lessons.patterns.behavioral.memento.example_1.Repository;
import info.md7.java.lessons.patterns.behavioral.memento.example_2.Originator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MementoTest {

  @Test
  void mementoTest(){
    Project project = new Project();
    Repository repository = new Repository();
    project.setVersion("1.0");
    repository.setSave(project.save());
    project.setVersion("2.0");
    Assertions.assertEquals("2.0", project.getVersion());
    project.load(repository.getSave());
    Assertions.assertEquals("1.0", project.getVersion());
  }

  @Test
  void mementoTestTwo() {
    Originator originator = new Originator();
    originator.setState("Hello World");
    Originator.Memento memento = originator.saveState();
    Assertions.assertEquals("Hello World", originator.getState());
    originator.setState("Some other text");
    Assertions.assertEquals("Some other text", originator.getState());
    originator.restoreState(memento);
    Assertions.assertEquals("Hello World", originator.getState());
  }

}
