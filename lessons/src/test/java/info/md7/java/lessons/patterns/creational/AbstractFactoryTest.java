package info.md7.java.lessons.patterns.creational;

import info.md7.java.lessons.patterns.creational.abstractFactory.BackendDeveloper;
import info.md7.java.lessons.patterns.creational.abstractFactory.FrontEndDeveloper;
import info.md7.java.lessons.patterns.creational.abstractFactory.WebDesigner;
import info.md7.java.lessons.patterns.creational.abstractFactory.WebsiteTeamFactory;
import info.md7.java.lessons.patterns.creational.abstractFactory.website.WebsiteTeamFactoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AbstractFactoryTest {

  @Test
  void testAbstractFactory() {
    WebsiteTeamFactory websiteTeamFactory = new WebsiteTeamFactoryImpl();
    WebDesigner webDesigner = websiteTeamFactory.getWebDesigner();
    BackendDeveloper backendDeveloper = websiteTeamFactory.getBackendDeveloper();
    FrontEndDeveloper frontEndDeveloper = websiteTeamFactory.getFrontendDeveloper();
    Assertions.assertEquals("Drawing new design", webDesigner.design());
    Assertions.assertEquals("Writing code for backend", backendDeveloper.writeCode());
    Assertions.assertEquals("Writing code for frontend", frontEndDeveloper.writeCode());
  }

}
