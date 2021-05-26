package ru.itis.game.repositories;

import org.springframework.stereotype.Component;
import ru.itis.game.models.Player;

import java.util.List;
import java.util.Optional;

/**
 * 15.05.2021
 * GameIntroMaven
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component("fakePlayersRepository")
public class PlayersRepositoryFakeImpl implements PlayersRepository {
    @Override
    public Optional<Player> findOneByNickname(String nickname) {
        return Optional.empty();
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
