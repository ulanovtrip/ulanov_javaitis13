package ru.itis.game.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.game.models.Game;
import ru.itis.game.models.Player;
import ru.itis.game.models.Shot;
import ru.itis.game.repositories.GamesRepository;
import ru.itis.game.repositories.PlayersRepository;
import ru.itis.game.repositories.ShotsRepository;

import java.time.LocalDateTime;
import java.util.Optional;

// слой сервиса отвечает за бизнес-логику

@Component
public class GameServiceImpl implements GameService {

    @Autowired
    private PlayersRepository playersRepository;
    @Autowired
    private GamesRepository gamesRepository;
    @Autowired
    private ShotsRepository shotsRepository;
    @Autowired
    private GameLogicService gameLogicService;

    @Override
    public Long startGame(String firstPlayer, String secondPlayer) {

        Player first = getPlayer(firstPlayer);
        Player second = getPlayer(secondPlayer);

        // сохраним игроков
        playersRepository.save(first);
        playersRepository.save(second);

        // создали игру
        Game game = Game.builder()
                .firstPlayer(first)
                .secondPlayer(second)
                .shotCount(0)
                .startGameDateTime(LocalDateTime.now())
                .build();

        // сохраним игру
        gamesRepository.save(game);

        //тут вернём id игры
        return game.getId();
    }

    @Override
    public boolean shot(Long gameId, String shooterNickname, String targetNickname) {

        // получаем двух игроков
        Optional<Player> shooterOptional = playersRepository.findOneByNickname(shooterNickname);
        Optional<Player> targetOptional = playersRepository.findOneByNickname(targetNickname);


        if (shooterOptional.isPresent()
                && targetOptional.isPresent()
                && gameLogicService.isHitTarget(shooterOptional.get().getId(), targetOptional.get().getId())) {

            // ищем в какой игре
            Optional<Game> gameOptional = gamesRepository.findById(gameId);

            if (gameOptional.isPresent()) {

                Player shooter = shooterOptional.get();
                Player target = shooterOptional.get();
                Game game = gameOptional.get();

                Shot shot = Shot.builder()
                        .shooter(shooter)
                        .target(target)
                        .game(game)
                        .build();

                shotsRepository.save(shot);

                // добавляем к текущему значению очков еще одно, если есть попадание
                shooter.setScore(shooter.getScore() + 1);
                playersRepository.update(shooter);
            }
            return true;
        }
        return false;
    }


    @Override
    public void finishGame(Long gameId) {
        Optional<Game> gameOptional = gamesRepository.findById(gameId);

        if (gameOptional.isPresent()) {
            Game game = gameOptional.get();
            game.setFinishGameDateTime(LocalDateTime.now());
            gamesRepository.update(game);
        } else {
            throw new IllegalArgumentException("Game not found");
        }
    }

    private Player getPlayer(String nickname) {

        Optional<Player> optionalPlayer = playersRepository.findOneByNickname(nickname);

        if (optionalPlayer.isPresent()) {
            return optionalPlayer.get();
        } else {
            // если в репозитории нет, то создаём нового
            Player player = Player.builder()
                    .nickname(nickname)
                    .build();
            // и сохраняем
            playersRepository.save(player);
            return player;
        }
    }
}
