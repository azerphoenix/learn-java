package info.md7.java.homeworks.enterprise.services.impl;


import info.md7.java.homeworks.enterprise.domains.User;
import info.md7.java.homeworks.enterprise.dto.UserDto;
import info.md7.java.homeworks.enterprise.repository.UserRepository;
import info.md7.java.homeworks.enterprise.services.UserService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final ModelMapper modelMapper;

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public User save(UserDto object) {
    User user = modelMapper.map(object, User.class);
    return userRepository.save(user);
  }

  @Override
  public User findById(Long key) {
    return userRepository.findById(key);
  }

  @Override
  public Optional<User> findOne(Long key) {
    return userRepository.findOne(key);
  }

  @Override
  public User update(UserDto object) {
    User user = modelMapper.map(object, User.class);
    return userRepository.update(user);
  }

  @Override
  public boolean delete(Long userId) {
    Optional<User> userOptional = userRepository.findOne(userId);
    return userOptional.map(userRepository::delete).orElseThrow(RuntimeException::new);
  }

  @Override
  public List<User> search(String query) {
    return userRepository.search(query);
  }
}
