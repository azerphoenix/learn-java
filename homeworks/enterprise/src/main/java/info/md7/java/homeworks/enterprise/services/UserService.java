package info.md7.java.homeworks.enterprise.services;


import info.md7.java.homeworks.enterprise.domains.User;
import info.md7.java.homeworks.enterprise.dto.UserDto;
import java.util.List;
import java.util.Optional;

public interface UserService {

  List<User> findAll();

  User save(UserDto object);

  User findById(Long key);

  Optional<User> findOne(Long key);

  User update(UserDto object);

  boolean delete(Long userId);

  List<User> search(String query);
}
