package ru.itis.game.repositories;

import java.util.List;
import java.util.Optional;

/**
 * 14.05.2021
 * GameIntroMaven
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface CrudRepository<T, ID> {
    List<T> findAll();

    Optional<T> findById(ID id);

    void save(T model);

    void update(T model);

    void delete(T model);

    void deleteById(ID id);
}
