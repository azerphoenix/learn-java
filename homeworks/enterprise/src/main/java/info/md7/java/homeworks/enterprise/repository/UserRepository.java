package info.md7.java.homeworks.enterprise.repository;


import info.md7.java.homeworks.enterprise.domains.User;
import java.util.List;

public interface UserRepository extends CrudRepository<Long, User> {

    List<User> search(String query);

}
