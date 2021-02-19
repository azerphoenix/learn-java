package info.md7.java.homeworks.enterprise.repository;


import info.md7.java.homeworks.enterprise.domains.Car;
import java.util.List;

public interface CarRepository extends CrudRepository<Long, Car> {

    List<Car> search(String query);

}
