package GameIntro.models;

public class Shot {
    // кто стрелял
    private Player shooter;
    // в кого стрелял
    private Player target;
    private Game game;

    public Shot(Game game) {
        this.game = game;
    }

    public Player getShooter() {
        return shooter;
    }

    public void setShooter(Player shooter) {
        this.shooter = shooter;
    }

    public Player getTarget() {
        return target;
    }

    public void setTarget(Player target) {
        this.target = target;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
