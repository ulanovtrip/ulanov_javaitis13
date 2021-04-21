package GameIntro.repositories;

import GameIntro.models.Game;

import java.util.ArrayList;
import java.util.List;

public class GamesRepositoryListImpl implements GamesRepository {

    private List<Game> games;

    public GamesRepositoryListImpl() {
        this.games = new ArrayList<>();
    }

    @Override
    public void save(Game game) {
        games.add(game);
    }

    @Override
    public Game findOneById(String gameId) {

        for (Game game : games) {
            if (game.getId().equals(gameId)) {
                return game;
            }
        }
        return null;
    }
}
