package GameIntro.repositories;

import GameIntro.models.Game;

public interface GamesRepository {
    void save(Game game);

    Game findOneById(String gameId);

    void update(Game game);
}
