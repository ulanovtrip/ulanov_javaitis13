package jdbc.dao.repositories;

import jdbc.dao.models.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountsRepositoryJdbcImpl implements AccountsRepository {

    // пишем сам запрос
    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from account order by id";

    // здесь нужно иметь connection к БД
    private Connection connection;

    public AccountsRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Account> findAll() {

        Statement statement = null;
        ResultSet rows = null;

        try {
            List<Account> accounts = new ArrayList<>();
            statement = connection.createStatement();
            rows = statement.executeQuery(SQL_SELECT_ALL);

            while (rows.next()) {
                // создаём объект и заполняем его
                Account account = new Account(
                        rows.getLong("id"),
                        rows.getString("first_name"),
                        rows.getString("last_name"),
                        rows.getBoolean("is_active")
                );

                // кладем объект в список
                accounts.add(account);
            }
            // как результат вернём список
            return accounts;

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Account findById(Long id) {
        return null;
    }

    @Override
    public void save(Account account) {

    }

    @Override
    public void update(Account account) {

    }

    @Override
    public void delete(Account account) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
