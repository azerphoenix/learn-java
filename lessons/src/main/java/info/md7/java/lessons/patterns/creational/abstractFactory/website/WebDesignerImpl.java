package info.md7.java.lessons.patterns.creational.abstractFactory.website;

import info.md7.java.lessons.patterns.creational.abstractFactory.WebDesigner;

public class WebDesignerImpl implements WebDesigner {

  @Override
  public String design() {
    return "Drawing new design";
  }

}
