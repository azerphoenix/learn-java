package info.md7.java.homeworks.enterprise.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<K,V> {

    V save(V object);
    List<V> findAll();
    V findById(K key);
    Optional<V> findOne(K key);
    V update(V object);

  boolean delete(V object);

}
