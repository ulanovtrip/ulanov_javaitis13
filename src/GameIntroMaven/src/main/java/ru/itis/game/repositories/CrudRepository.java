package ru.itis.game.repositories;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID> {

    List<T> findAll();

    Optional<T> findById(ID id);

    void save(T account);

    void update(T account);

    void delete(T account);

    void deleteById(ID id);
}
