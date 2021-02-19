package info.md7.java.homeworks.enterprise.repository;


import info.md7.java.homeworks.enterprise.domains.Dealer;
import java.util.List;

public interface DealerRepository extends CrudRepository<Long, Dealer> {

  List<Dealer> search(String query);

}
