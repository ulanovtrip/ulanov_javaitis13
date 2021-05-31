package ru.itis.game.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itis.game.models.Player;

import java.util.List;
import java.util.Optional;


@Component(value = "playersRepository")
public class PlayersRepositoryJdbcTemplateImpl implements PlayersRepository {

    //language=SQL
    private static final String SQL_FIND_BY_NICKNAME = "select * from player where nickname = ?";

    //language=SQL
    private static final String SQL_INSERT_PLAYER = "insert into player(nickname, password) values (?, ?)";

    private RowMapper<Player> playerRowMapper = (row, rowNumber) -> Player.builder()
            .id(row.getLong("id"))
            .nickname(row.getString("nickname"))
            .password(row.getString("password"))
            .build();

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PlayersRepositoryJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Player> findOneByNickname(String nickname) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_FIND_BY_NICKNAME, playerRowMapper, nickname));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Player> findAll() {
        return null;
    }

    @Override
    public Optional<Player> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void save(Player account) {
        jdbcTemplate.update(SQL_INSERT_PLAYER, account.getNickname(), account.getPassword());
    }

    @Override
    public void update(Player account) {

    }

    @Override
    public void delete(Player account) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
