package GameIntro.repositories;


import GameIntro.models.Game;
import GameIntro.models.Player;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class GamesRepositoryFileBasedImpl implements GamesRepository {

    String fileName;

    public GamesRepositoryFileBasedImpl(String fileName) {
        this.fileName = fileName;
    }

    // маппер для преобразования игры в строку
    private Mapper<Game, String> gameToStringLineMapper = game -> {
        // эта функция нужна чтобы преобразовния информации об игре в стоку
        StringBuilder line = new StringBuilder();
        line.append(game.getId())
                .append("|")
                .append(game.getStartGameDateTime().toString())
                .append("|");

        if (game.getFinishGameDateTime() == null) {
            line.append("NULL")
                    .append("|");
        } else {
            line.append(game.getFinishGameDateTime())
                    .append("|");
        }

        line.append(game.getFirstPlayer().getNickname())
                .append("|")
                .append(game.getSecondPlayer().getNickname())
                .append("|");

        if (game.getShotCount() == null) {
            line.append("NULL").append("|");
        } else {
            line.append(game.getShotCount())
                    .append("|");
        }

        return line.toString();
    };

    // маппер для преобразования строки в игру
    private Mapper<String, Game> stringLineToGameMapper = line -> {
        Game game = new Game();
        String[] parsedLine = line.split("\\|");
        game.setId(parsedLine[0]);
        game.setStartGameDateTime(LocalDateTime.parse(parsedLine[1]));

        if (parsedLine[2].equals("NULL")) {
            game.setFinishGameDateTime(null);
        } else {
            game.setFinishGameDateTime(LocalDateTime.parse(parsedLine[2]));
        }

        game.setFirstPlayer(new Player(parsedLine[3]));
        game.setSecondPlayer(new Player(parsedLine[4]));

        if (parsedLine[5].equals("NULL")) {
            game.setShotCount(null);
        } else {
            game.setShotCount(Integer.parseInt(parsedLine[5]));
        }

        return game;
    };

    @Override
    public void save(Game game) {
        String lineToSave = gameToStringLineMapper.map(game);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(lineToSave + "\n");
            writer.close();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Game findOneById(String gameId) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String lineFromFile = bufferedReader.readLine();

            // нужно найти игру по id
            while (lineFromFile != null) {
                // сначала получаем игру
                Game game = stringLineToGameMapper.map(lineFromFile);
                //смотрим id
                if (game.getId().equals(gameId)) {
                    // если совпало, то вернём эту игру
                    return game;
                }
                // если не совпало, то считываем дальше
                lineFromFile = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return null;
    }

    @Override
    public void update(Game game) {
        // TODO: 24.04.2021 Внимательно разобраться как работает этот метод

        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            List<Game> gamesFromFile = reader
                    // получаем все строки из файла
                    .lines()
                    // применится функция map, преобразуем все строки в объекты Game
                    .map(stringLineToGameMapper::map)
                    .collect(Collectors.toList());

            // теперь ищем игру с нужным id
            Game gameFromFile = gamesFromFile.stream()
                    // находим все игры с нужным id
                    .filter(existedGame -> existedGame.getId().equals(game.getId()))
                    // ограничеваем выборку до 1-го элемента
                    .limit(1)
                    // преобразуем в список
                    .collect(Collectors.toList())
                    // возьмём первый элемент
                    .get(0);

            // заменили у нужной игры время
            gameFromFile.setFinishGameDateTime(game.getFinishGameDateTime());

            // теперь нужно все считанные игры записать в файл. Одну игру не получится перезаписать.
            // т.е. нельзя заменить одну строчку в файле

            // если у существующей игры id совпал с id игры которую мы обновили, тогда удаляем из списка
            gamesFromFile.removeIf(existedGame -> existedGame.getId().equals(gameFromFile.getId()));
            // и заменим на новый
            gamesFromFile.add(gameFromFile);
            // закрыли поток
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            // для каждого элемента (игры из списка) сохраним в файл
            gamesFromFile.forEach(newGame -> {
                try {
                    writer.write(gameToStringLineMapper.map(newGame) + "\n");
                } catch (IOException e) {
                    throw new IllegalArgumentException(e);
                }
            });
            // закрыть поток
            writer.close();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
