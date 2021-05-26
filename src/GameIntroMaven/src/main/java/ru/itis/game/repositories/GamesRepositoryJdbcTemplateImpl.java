package ru.itis.game.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.itis.game.models.Game;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

/**
 * 14.05.2021
 * GameIntroMaven
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component(value = "gamesRepository")
public class GamesRepositoryJdbcTemplateImpl implements GamesRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GamesRepositoryJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Game> findAll() {
        return null;
    }

    @Override
    public Optional<Game> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void save(Game account) {

    }

    @Override
    public void update(Game account) {

    }

    @Override
    public void delete(Game account) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
