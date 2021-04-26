package stream_api.files;


import java.util.List;

public interface ShotsRepository {
    List<Shot> findAll();
    List<Shot> findAllByShooterNickname(String nickname);
}
