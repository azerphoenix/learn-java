package info.md7.java.homeworks.enterprise.services;


import info.md7.java.homeworks.enterprise.domains.Car;
import info.md7.java.homeworks.enterprise.dto.CarDto;
import java.util.List;
import java.util.Optional;

public interface CarService {

  Car save(CarDto object);

  List<Car> findAll();

  Car findById(Long key);

  Optional<Car> findOne(Long key);

  Car update(CarDto object);

  boolean delete(Long carId);

  List<Car> search(String query);
}
