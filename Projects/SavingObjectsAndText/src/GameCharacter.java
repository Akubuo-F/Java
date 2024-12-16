import java.io.Serial;
import java.io.Serializable;

public class GameCharacter implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L; /*
    Override the serialVersionUID if there is any
    possibility that the class might evolve.
    */
    int power;
    String type;
    String[] weapons;

    public GameCharacter(int power, String type, String[] weapons) {
        this.power = power;
        this.type = type;
        this.weapons = weapons;
    }

    public String getType() {
        return type;
    }

    public int getPower() {
        return power;
    }

    public String[] getWeapons() {
        return weapons;
    }
}
