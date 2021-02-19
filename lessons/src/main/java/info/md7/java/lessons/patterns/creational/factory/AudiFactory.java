package info.md7.java.lessons.patterns.creational.factory;

public class AudiFactory implements CarFactory {

  @Override
  public Car createCar() {
    return new Audi();
  }

}
