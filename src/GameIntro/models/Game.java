package GameIntro.models;

import java.time.LocalDateTime;

public class Game {
    private String id;
    private LocalDateTime startGameDateTime;
    private LocalDateTime finishGameDateTime;
    private Player firstPlayer;
    private Player secondPlayer;
    private Integer shotCount;
    // TODO: 21.04.2021 считать колличество выстрелов

    public Game(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getStartGameDateTime() {
        return startGameDateTime;
    }

    public void setStartGameDateTime(LocalDateTime startGameDateTime) {
        this.startGameDateTime = startGameDateTime;
    }

    public LocalDateTime getFinishGameDateTime() {
        return finishGameDateTime;
    }

    public void setFinishGameDateTime(LocalDateTime finishGameDateTime) {
        this.finishGameDateTime = finishGameDateTime;
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public Integer getShotCount() {
        return shotCount;
    }

    public void setShotCount(Integer shotCount) {
        this.shotCount = shotCount;
    }
}
