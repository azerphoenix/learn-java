package info.md7.java.homeworks.hw_9.enums;

import java.time.Year;

public enum CarBrand {

  MERCEDES ("Mercedes", "Германия", Year.of(1901)),
  TOYOTA("Toyota", "Япония", Year.of(1937)),
  AUDI("Audi", "Германия", Year.of(1909)),
  MAZDA("Mazda", "Япония", Year.of(1920)),
  BMW("BMW", "Германия", Year.of(1916)),
  TESLA("Tesla", "США", Year.of(2003)),
  LADA("Lada", "Россия", Year.of(1966));

  public String brandName;
  public String country;
  public Year yearOfFoundation;

  CarBrand(String brandName, String country, Year yearOfFoundation) {
    this.brandName = brandName;
    this.country = country;
    this.yearOfFoundation = yearOfFoundation;
  }

}
