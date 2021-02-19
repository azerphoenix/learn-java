package info.md7.java.lessons.patterns.creational.factory;

public class MercedesFactory implements CarFactory {

  @Override
  public Car createCar() {
    return new Mercedes();
  }

}
