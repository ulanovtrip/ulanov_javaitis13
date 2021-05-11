package repositories;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID> {

    List<T> findAll();

    // Optional гарантирует, что мы всегда что-то получим при вызове метода, не нужно лезть в код
    // т.е. это помощник, чтобы понять, нужно ли проверять это на null
    Optional<T> findById(ID id);

    void save(T account);

    void update(T account);

    void delete(T account);

    void deleteById(ID id);
}
