package info.md7.java.homeworks.enterprise.services;


import info.md7.java.homeworks.enterprise.domains.Dealer;
import info.md7.java.homeworks.enterprise.dto.DealerDto;
import java.util.List;
import java.util.Optional;

public interface DealerService {

  Dealer save(DealerDto object);

  List<Dealer> findAll();

  Dealer findById(Long key);

  Optional<Dealer> findOne(Long key);

  Dealer update(DealerDto object);

  boolean delete(Long dealerId);

  List<Dealer> search(String query);
}
