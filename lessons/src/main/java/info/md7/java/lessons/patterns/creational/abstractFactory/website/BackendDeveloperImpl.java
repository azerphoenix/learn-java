package info.md7.java.lessons.patterns.creational.abstractFactory.website;

import info.md7.java.lessons.patterns.creational.abstractFactory.BackendDeveloper;

public class BackendDeveloperImpl implements BackendDeveloper {

  @Override
  public String writeCode() {
    return "Writing code for backend";
  }

}
