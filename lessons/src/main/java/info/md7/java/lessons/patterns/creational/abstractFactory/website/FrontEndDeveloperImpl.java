package info.md7.java.lessons.patterns.creational.abstractFactory.website;

import info.md7.java.lessons.patterns.creational.abstractFactory.FrontEndDeveloper;

public class FrontEndDeveloperImpl implements FrontEndDeveloper {

  @Override
  public String writeCode() {
    return "Writing code for frontend";
  }

}
