package ru.itis.game.services;

import ru.itis.game.dto.MessageDto;
import ru.itis.game.dto.UsernamePasswordDto;
import ru.itis.game.models.Client;

public interface GameService {

    void connect(String ip);

    void saveMessage(MessageDto message);

    /**
     * Аутентифицирует пользователя
     * @param usernamePasswordDto логин и пароль
     * @return true, если аутентификация успешна, иначе false
     */
    boolean authenticate(UsernamePasswordDto usernamePasswordDto);

    /**
     * Начинает игру. В случае, если игрок уже был в системе
     * то будет использованы его данные, если игрока в системе
     * до этого не было, то игрок создается заново
     * Никнейм - уникальный
     * @param firstPlayer никнейм первого игрока
     * @param secondPlayer никнейм второго игрока
     * @return идентификатор игры
     */
    Long startGame(String firstPlayer, String secondPlayer);

    boolean shot(Long gameId, String shooterNickname, String targetNickname);

    void finishGame(Long gameId);

    void singUp(UsernamePasswordDto usernamePasswordDto);
}
