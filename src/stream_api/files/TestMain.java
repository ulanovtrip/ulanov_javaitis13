package stream_api.files;

public class TestMain {
    public static void main(String[] args) {
        ShotsRepository shotsRepository = new ShotsRepositoryFilesImpl("src/stream_api/files/games.txt");
        System.out.println(shotsRepository.findAll());
        System.out.println(shotsRepository.findAllByShooterNickname("rat"));
    }
}
