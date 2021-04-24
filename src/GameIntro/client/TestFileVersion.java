package GameIntro.client;

import GameIntro.repositories.*;
import GameIntro.service.GameService;
import GameIntro.service.GameServiceImpl;

import java.util.Scanner;

public class TestFileVersion {
    public static void main(String[] args) {

        ShotsRepository shotsRepository = new ShotsRepositoryListImpl();
        GamesRepository gamesRepository = new GamesRepositoryFileBasedImpl("src/GameIntro/repositories/games.txt");
        PlayersRepository playersRepository = new PlayersRepositoryMapImpl();

        GameService gameService = new GameServiceImpl(playersRepository, gamesRepository, shotsRepository);
        Scanner scanner = new Scanner(System.in);

        // стартуют игры
        int i = 0;
        while (i < 3) {
            System.out.println("Введите имена игроков: ");
            String firstName = scanner.nextLine();
            String secondName = scanner.nextLine();
            String gameId = gameService.startGame(firstName, secondName);

            String shooter = firstName;
            String target = secondName;

            int j = 0;
            while (j < 2) {
                System.out.println("Стреляйте " + shooter + " в " + target);
                scanner.nextLine();
                if (gameService.shot(gameId, shooter, target)) {
                    System.out.println("Попали!");
                } else {
                    System.out.println("Не попал!");
                }

                // теперь меняем их местами
                String temp = shooter;
                shooter = target;
                target = temp;
                j++;
            }

            // заканчиваем игру
            gameService.finishGame(gameId);
            i++;
        }
    }
}
