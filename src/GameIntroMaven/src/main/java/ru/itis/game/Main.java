package ru.itis.game;

import ru.itis.game.server.GameServer;


public class Main {
    public static void main(String[] args) {
        GameServer gameServer = new GameServer();
        // старт сервера
        gameServer.start(7777);
    }
}
