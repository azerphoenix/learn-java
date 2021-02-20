package info.md7.java.lessons.patterns.structural;

import info.md7.java.lessons.patterns.structural.facade.Workflow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FacadeTest {

  @Test
  void facadeTest(){
    Workflow workflow = new Workflow();
    Assertions.assertEquals("Developing a project Sprint is active Developer working!", workflow.start());
  }

}
