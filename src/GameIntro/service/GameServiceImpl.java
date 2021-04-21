package GameIntro.service;

import GameIntro.models.Game;
import GameIntro.models.Player;
import GameIntro.models.Shot;
import GameIntro.repositories.GamesRepository;
import GameIntro.repositories.PlayersRepository;
import GameIntro.repositories.ShotsRepository;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.UUID;

// слой сервиса отвечает за бизнес-логику

public class GameServiceImpl implements GameService {

    private PlayersRepository playersRepository;
    private GamesRepository gamesRepository;
    private ShotsRepository shotsRepository;
    private SecureRandom random;

    public GameServiceImpl(PlayersRepository playersRepository, GamesRepository gamesRepository, ShotsRepository shotsRepository) {
        this.playersRepository = playersRepository;
        this.gamesRepository = gamesRepository;
        this.shotsRepository = shotsRepository;
        this.random = new SecureRandom();
    }

    @Override
    public String startGame(String firstPlayer, String secondPlayer) {

        Player first = getPlayer(firstPlayer);
        Player second = getPlayer(secondPlayer);

        // сохраним игроков
        playersRepository.save(first);
        playersRepository.save(second);

        // создали игру с идентификатором
        Game game = new Game(UUID.randomUUID().toString());
        // задали игре игроков и кол-во выстрелов + дата и время
        game.setFirstPlayer(first);
        game.setSecondPlayer(second);
        game.setShotCount(0);
        game.setStartGameDateTime(LocalDateTime.now());

        // сохраним игру
        gamesRepository.save(game);

        //тут вернём id игры
        return game.getId();
    }

    @Override
    public boolean shot(String gameId, String shooterNickname, String targetNickname) {

        int chance = random.nextInt(10);

        if (chance > 4) {
            // получаем двух игроков
            Player shooter = playersRepository.findOneByNickname(shooterNickname);
            Player target = playersRepository.findOneByNickname(targetNickname);
            // ищем в какой игре
            Game game = gamesRepository.findOneById(gameId);

            Shot shot = new Shot(game);
            shot.setShooter(shooter);
            shot.setTarget(target);
            shotsRepository.save(shot);

            // проверка на null, чтобы небыло эксепшенов
            if(shooter.getScore() == null) {
                shooter.setScore(0);
            }

            // добавляем к текущему значению очков еще одно, если есть попадание
            shooter.setScore(shooter.getScore() + 1);
            return true;
        }
        return false;
    }

    @Override
    public void finishGame(String gameId) {
        Game game = gamesRepository.findOneById(gameId);
        game.setFinishGameDateTime(LocalDateTime.now());
    }

    private Player getPlayer(String nickname) {
        Player player;
        // проверка есть ли игрок под этим именем в хранилище?
        if (playersRepository.containsByNickName(nickname)) {
            // если есть, то достаём его из репозитория
            player = playersRepository.findOneByNickname(nickname);
        } else {
            // если в репозитории нет, то создаём нового
            player = new Player(nickname);
            // и сохраняем
            playersRepository.save(player);
        }
        return player;
    }
}
