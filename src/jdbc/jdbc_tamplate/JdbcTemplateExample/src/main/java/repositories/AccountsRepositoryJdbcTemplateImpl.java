package repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.itis.site.models.Account;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AccountsRepositoryJdbcTemplateImpl implements AccountsRepository {

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from account order by id";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from account where id = ?";

    //language=SQL
    private static final String SQL_INSERT = "insert into account(first_name, last_name, is_active) values (?, ?, ?)";

    //language=SQL
    private static final String SQL_UPDATE = "update account set first_name = ?, last_name = ?, is_active = ? where id = ?";

    private JdbcTemplate jdbcTemplate;

    public AccountsRepositoryJdbcTemplateImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // пишем свой rowmapper на билдере
    RowMapper<Account> accountRowMapper = (row, rowNumber) -> {
        return Account.builder()
                .id(row.getLong("id"))
                .firstName(row.getString("first_name"))
                .lastName(row.getString("last_name"))
                .isActive(row.getBoolean("is_active"))
                .build();
    };

    @Override
    public List<Account> findAll() {
        // в параметры запроса кладём sql скрипт и маппер
        return jdbcTemplate.query(SQL_SELECT_ALL, accountRowMapper);
    }

    @Override
    public Optional<Account> findById(Long id) {
        // если записи в БД нет, то вернём null, вместо эксепшена
        try {

            // получаем сначала объект Account
            Account account = jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, accountRowMapper, id);
            // затем оборачиваем его в Optional и возвращаем
            Optional<Account> result = Optional.of(account);
            return result;
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void save(Account account) {
        // KeyHolder позволит получить доступ к сгенерированным БД ключам
        KeyHolder keyHolder = new GeneratedKeyHolder();

        // такая конструкция нужна, если необходимо получить сгенерированный ключ, это пример для jdbcTamplate
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        // Statement.RETURN_GENERATED_KEYS - этот флаг для того, чтобы prepareStatement вернул сгенерированный в БД ID
                        // после выполнения executeUpdate
                        PreparedStatement statement = connection.prepareStatement(SQL_INSERT, new String[]{"id"});
                        statement.setString(1, account.getFirstName());
                        statement.setString(2, account.getLastName());
                        statement.setBoolean(3, account.getIsActive());
                        return statement;
                    }
                }, keyHolder);

        // зададим сгенерированное значение как ID
        account.setId(keyHolder.getKey().longValue());
    }

    @Override
    public void update(Account account) {
        jdbcTemplate.update(SQL_UPDATE, account.getFirstName(), account.getLastName(), account.getIsActive(), account.getId());
    }

    @Override
    public void delete(Account account) {
        // TODO: 07.05.2021
    }

    @Override
    public void deleteById(Long aLong) {
        // TODO: 07.05.2021
    }
}
