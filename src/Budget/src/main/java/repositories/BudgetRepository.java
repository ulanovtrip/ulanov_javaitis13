package repositories;

import java.util.List;
import java.util.Optional;

public interface BudgetRepository<Purchase, ID> {

    List<Purchase> findAllByTitle(String title);

    void create(Purchase purchase);

    Optional<Purchase> readById(ID id);

    void update(Purchase purchase);

    void delete(Purchase purchase);
}
