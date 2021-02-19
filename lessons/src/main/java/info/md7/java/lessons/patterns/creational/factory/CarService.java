package info.md7.java.lessons.patterns.creational.factory;

public class CarService {

  public static CarFactory createCarFactoryByBrand(ECar eCar) {
    switch (eCar) {
      case AUDI:
        return new AudiFactory();
      case MERCEDES:
        return new MercedesFactory();
      default:
        return new AudiFactory();
    }
  }

}
