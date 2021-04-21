package GameIntro.repositories;

import GameIntro.models.Player;

public interface PlayersRepository {

    void save(Player player);

    // проверит, есть ли такой игрок уже
    boolean containsByNickName(String nickname);

    Player findOneByNickname(String firstPlayer);
}
