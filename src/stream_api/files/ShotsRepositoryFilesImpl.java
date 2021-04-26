package stream_api.files;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ShotsRepositoryFilesImpl implements ShotsRepository {

    private final static Function<String, Shot> shotMapper = line -> {
        String[] parseLine = line.split("\\|");
        // парсим из строки файла в объект Shot
        return new Shot(parseLine[0],
                LocalDateTime.parse(parseLine[1]),
                LocalDateTime.parse(parseLine[2]),
                parseLine[3],
                parseLine[4],
                Long.parseLong(parseLine[5]));
    };

    // имя файла с которого будем читать
    private String fileName;

    public ShotsRepositoryFilesImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Shot> findAll() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

            // прочитаем все строки из файла в виде строк
            List<Shot> shots = bufferedReader
                    .lines()
                    .map(shotMapper)
                    .collect(Collectors.toList());
            bufferedReader.close();
            return shots;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<Shot> findAllByShooterNickname(String nickname) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

            // прочитаем все строки из файла в виде строк
            List<Shot> shots = bufferedReader
                    .lines()
                    .map(shotMapper)
                    .filter(shot -> shot.getShooter().equals(nickname))
                    .collect(Collectors.toList());
            bufferedReader.close();
            return shots;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
