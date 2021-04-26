package stream_api.files;

import GameIntro.models.Player;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class Shot {
    private String id;
    private LocalDateTime dateTime;
    private LocalDateTime finish;
    private Long gameId;
    private String shooter;
    private String target;

    public Shot(String id, LocalDateTime dateTime, LocalDateTime finish, String shooter, String target, Long gameId) {
        this.id = id;
        this.dateTime = dateTime;
        this.finish = finish;
        this.gameId = gameId;
        this.shooter = shooter;
        this.target = target;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getShooter() {
        return shooter;
    }

    public void setShooter(String shooter) {
        this.shooter = shooter;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shot shot = (Shot) o;
        return Objects.equals(id, shot.id) && Objects.equals(dateTime, shot.dateTime) && Objects.equals(gameId, shot.gameId) && Objects.equals(shooter, shot.shooter) && Objects.equals(target, shot.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateTime, gameId, shooter, target);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Shot.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("dateTime=" + dateTime)
                .add("gameId=" + gameId)
                .add("shooter=" + shooter)
                .add("target=" + target)
                .toString();
    }
}
