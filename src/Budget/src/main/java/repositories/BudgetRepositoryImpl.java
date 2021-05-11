package repositories;

import models.Purchase;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class BudgetRepositoryImpl implements BudgetRepository<Purchase, Long> {

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from budget order by id";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from budget where id = ?";

    //language=SQL
    private static final String SQL_SELECT_BY_TITLE = "select * from budget where title = ?";

    //language=SQL
    private static final String SQL_INSERT = "insert into budget(title, sum, date_time) values (?, ?, ?)";

    //language=SQL
    private static final String SQL_UPDATE = "update account set first_name = ?, last_name = ?, is_active = ? where id = ?";

    // переменная для jdbcTemplate
    private JdbcTemplate jdbcTemplate;

    public BudgetRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    RowMapper<Purchase> budgetRowMapper = (row, rowNumber) -> {
        return Purchase.builder()
                .id(row.getInt("id"))
                .title(row.getString("title"))
                .sum(row.getLong("sum"))
                .dateTime(row.getString("date_time"))
                .build();
    };


    @Override
    public List<Purchase> findAllByTitle(String title) {
        List<Purchase> purchaseList = jdbcTemplate.query(SQL_SELECT_BY_TITLE, budgetRowMapper, title);
        return purchaseList;
    }

    @Override
    public void create(Purchase purchase) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement statement = connection.prepareStatement(SQL_INSERT, new String[]{"id"});
                    statement.setString(1, purchase.getTitle());
                    statement.setLong(2, purchase.getSum());
                    statement.setString(3, purchase.getDateTime());
                    return statement;
                }, keyHolder);
        purchase.setId(keyHolder.getKey().intValue());
    }

    @Override
    public Optional<Purchase> readById(Long id) {
        try {
            Purchase purchase = jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, budgetRowMapper, id);
            Optional<Purchase> result = Optional.of(purchase);
            return result;
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void update(Purchase purchase) {

    }

    @Override
    public void delete(Purchase purchase) {

    }
}
