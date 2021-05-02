package jdbc.dao.repositories;

import jdbc.dao.models.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountsRepositoryJdbcImpl implements AccountsRepository {

    // пишем сам запрос
    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from account order by id";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from account where id = ?";

    //language=SQL
    private static final String SQL_INSERT = "insert into account(first_name, last_name, is_active) values (?, ?, ?)";

    //language=SQL
    private static final String SQL_UPDATE = "update account set first_name = ?, last_name = ?, is_active = ? where id = ?";

    // здесь нужно иметь connection к БД
    private Connection connection;

    public AccountsRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    RowMapper<Account> accountRowMapper = row -> new Account(
            row.getLong("id"),
            row.getString("first_name"),
            row.getString("last_name"),
            row.getBoolean("is_active"));


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
                Account account = accountRowMapper.mapRow(rows);
                // кладем объект в список
                accounts.add(account);
            }
            // как результат вернём список
            return accounts;

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            // необходимо закрыть ResultSet, и потом Statement
            if (rows != null) {
                try {
                    rows.close();
                } catch (SQLException e) {
                    // ignore
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // ignore
                }
            }
        }
    }

    @Override
    public Account findById(Long id) {

        // PreparedStatement - позволяет избежать sql инъекций
        PreparedStatement statement = null;
        ResultSet rows = null;

        try {

            statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setLong(1, id);
            rows = statement.executeQuery();

            if (rows.next()) {
                // создаём объект и заполняем его
                return accountRowMapper.mapRow(rows);
            }
            // как результат объект
            return null;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            // необходимо закрыть ResultSet, и потом Statement
            if (rows != null) {
                try {
                    rows.close();
                } catch (SQLException e) {
                    // ignore
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // ignore
                }
            }
        }
    }

    @Override
    public void save(Account account) {

        // PreparedStatement - позволяет избежать sql инъекций
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;

        try {

            // Statement.RETURN_GENERATED_KEYS - этот флаг для того, чтобы prepareStatement вернул сгенерированный в БД ID
            // после выполнения executeUpdate
            statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, account.getFirstName());
            statement.setString(2, account.getLastName());
            statement.setBoolean(3, account.getActive());

            // executeUpdate вернёт число изменённых строк
            int affectedRows = statement.executeUpdate();

            // проверка, были ли изменения в БД, т.е. прошёл ли запрос успешно
            if (affectedRows != 1) {
                throw new SQLException("I can't insert!");
            }

            // получаем сгенерированный ключи
            generatedKeys = statement.getGeneratedKeys();

            // если есть что-то сгенерированное из ключей
            if (generatedKeys.next()) {
                // если есть сгенерированный ключ, то вытащим и сохраним
                account.setId(generatedKeys.getLong("id"));
            } else {
                throw new SQLException("Can't retrieve ID");
            }

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            if (statement != null && generatedKeys != null) {
                try {
                    generatedKeys.close();
                    statement.close();
                } catch (SQLException e) {
                    // ignore
                }
            }
        }
    }

    @Override
    public void update(Account account) {
        // PreparedStatement - позволяет избежать sql инъекций
        PreparedStatement statement = null;

        try {

            // Statement.RETURN_GENERATED_KEYS - этот флаг для того, чтобы prepareStatement вернул сгенерированный в БД ID
            // после выполнения executeUpdate
            statement = connection.prepareStatement(SQL_UPDATE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, account.getFirstName());
            statement.setString(2, account.getLastName());
            statement.setBoolean(3, account.getActive());
            statement.setLong(4, account.getId());

            // executeUpdate вернёт число изменённых строк
            int affectedRows = statement.executeUpdate();

            // проверка, были ли изменения в БД, т.е. прошёл ли запрос успешно
            if (affectedRows != 1) {
                throw new SQLException("I can't update!");
            }


        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // ignore
                }
            }
        }
    }

    @Override
    public void delete(Account account) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
