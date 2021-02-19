package info.md7.java.lessons.patterns.creational.abstractFactory;

public interface WebsiteTeamFactory {

  BackendDeveloper getBackendDeveloper();

  FrontEndDeveloper getFrontendDeveloper();

  WebDesigner getWebDesigner();

}
