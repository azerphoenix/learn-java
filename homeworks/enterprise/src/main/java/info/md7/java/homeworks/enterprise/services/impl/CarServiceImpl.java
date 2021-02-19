package info.md7.java.homeworks.enterprise.services.impl;


import info.md7.java.homeworks.enterprise.domains.Car;
import info.md7.java.homeworks.enterprise.dto.CarDto;
import info.md7.java.homeworks.enterprise.repository.CarRepository;
import info.md7.java.homeworks.enterprise.services.CarService;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

  private final CarRepository carRepository;
  private final ModelMapper modelMapper;

  @Override
  public Car save(CarDto object) {
    Car car = modelMapper.map(object, Car.class);
    car.setGuaranteeExpirationDate(Timestamp.valueOf(LocalDateTime.now()));
    return carRepository.save(car);
  }

  @Override
  public List<Car> findAll() {
    return carRepository.findAll();
  }

  @Override
  public Car findById(Long key) {
    return carRepository.findById(key);
  }

  @Override
  public Optional<Car> findOne(Long key) {
    return carRepository.findOne(key);
  }

  @Override
  public Car update(CarDto object) {
    Car car = modelMapper.map(object, Car.class);
    return carRepository.update(car);
  }

  @Override
  public boolean delete(Long carId) {
    Optional<Car> carOptional = carRepository.findOne(carId);
    return carOptional.map(carRepository::delete).orElseThrow(RuntimeException::new);
  }

  @Override
  public List<Car> search(String query) {
    return carRepository.search(query);
  }
}
