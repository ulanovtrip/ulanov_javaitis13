package ru.itis.game.services;

public interface GameService {
    /**
     * Начинает игру. В случае, если уже был в системе, то будут использованы его данные.
     * Если игрока ещё небыло, то он создаётся заново.
     *
     * @param firstPlayer  никнейм первого игрока
     * @param secondPlayer никнейм второго
     */

    Long startGame(String firstPlayer, String secondPlayer);

    boolean shot(Long gameId, String shooterNickname, String targetNickname);

    void finishGame(Long gameId);
}
