package info.md7.java.lessons.patterns.structural.decorator;

public class DeveloperDecorator implements Developer {

  private Developer developer;

  public DeveloperDecorator(Developer developer) {
    this.developer = developer;
  }

  @Override
  public String writeCode() {
    return developer.writeCode();
  }

}
