package GameIntro.repositories;

import GameIntro.models.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayersRepositoryMapImpl implements PlayersRepository {

    Map<String, Player> players;

    public PlayersRepositoryMapImpl() {
        this.players = new HashMap<>();
    }

    @Override
    public void save(Player player) {
        players.put(player.getNickname(), player);
    }

    @Override
    public boolean containsByNickName(String nickname) {
        return players.containsKey(nickname);
    }

    @Override
    public Player findOneByNickname(String player) {
        return players.get(player);
    }
}
