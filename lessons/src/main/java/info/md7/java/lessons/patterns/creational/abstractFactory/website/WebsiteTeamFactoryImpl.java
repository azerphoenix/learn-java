package info.md7.java.lessons.patterns.creational.abstractFactory.website;

import info.md7.java.lessons.patterns.creational.abstractFactory.BackendDeveloper;
import info.md7.java.lessons.patterns.creational.abstractFactory.FrontEndDeveloper;
import info.md7.java.lessons.patterns.creational.abstractFactory.WebDesigner;
import info.md7.java.lessons.patterns.creational.abstractFactory.WebsiteTeamFactory;

public class WebsiteTeamFactoryImpl implements WebsiteTeamFactory {

  @Override
  public BackendDeveloper getBackendDeveloper() {
    return new BackendDeveloperImpl();
  }

  @Override
  public FrontEndDeveloper getFrontendDeveloper() {
    return new FrontEndDeveloperImpl();
  }

  @Override
  public WebDesigner getWebDesigner() {
    return new WebDesignerImpl();
  }
}
