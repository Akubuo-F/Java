public class StartUpShip {
    private final int id;
    private final String name;
    private int lives;

    StartUpShip(int id, String name, int lives) {
        this.id = id;
        this.name = name;
        this.lives = lives;
    }

    public void decrementLive() {
        this.lives--;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLives() {
        return lives;
    }
}
