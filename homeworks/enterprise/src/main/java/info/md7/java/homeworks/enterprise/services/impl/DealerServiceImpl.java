package info.md7.java.homeworks.enterprise.services.impl;


import info.md7.java.homeworks.enterprise.domains.Dealer;
import info.md7.java.homeworks.enterprise.dto.DealerDto;
import info.md7.java.homeworks.enterprise.repository.DealerRepository;
import info.md7.java.homeworks.enterprise.services.DealerService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DealerServiceImpl implements DealerService {

  private final DealerRepository dealerRepository;
  private final ModelMapper modelMapper;

  @Override
  public Dealer save(DealerDto object) {
    Dealer dealer = modelMapper.map(object, Dealer.class);
    return dealerRepository.save(dealer);
  }

  @Override
  public List<Dealer> findAll() {
    return dealerRepository.findAll();
  }

  @Override
  public Dealer findById(Long key) {
    return dealerRepository.findById(key);
  }

  @Override
  public Optional<Dealer> findOne(Long key) {
    return dealerRepository.findOne(key);
  }

  @Override
  public Dealer update(DealerDto object) {
    Dealer dealer = modelMapper.map(object, Dealer.class);
    return dealerRepository.update(dealer);
  }

  @Override
  public boolean delete(Long dealerId) {
    Optional<Dealer> dealerOptional = dealerRepository.findOne(dealerId);
    return dealerOptional.map(dealerRepository::delete).orElseThrow(RuntimeException::new);
  }

  @Override
  public List<Dealer> search(String query) {
    return dealerRepository.search(query);
  }
}
