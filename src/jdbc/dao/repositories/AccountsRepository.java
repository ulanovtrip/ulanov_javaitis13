package jdbc.dao.repositories;

import jdbc.dao.models.Account;

import java.util.List;

/**
 * Так как неизвестно как будет реализована работа с данными, то
 * пишем сначала интерфейс.
 *
 * DAO - data access object - это CRUD интерфейс + реализации, это паттерн.
 */

public interface AccountsRepository {

    // crud репозиторий

    List<Account> findAll();

    Account findById(Long id);

    void save(Account account);

    void update(Account account);

    void delete(Account account);

    void deleteById(Long id);
}
