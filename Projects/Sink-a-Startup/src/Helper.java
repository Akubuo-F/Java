import java.util.Random;


public class Helper {
    public static Vector2D getRandomDirection() {
        Random random = new Random();
        Vector2D[] directions = new Vector2D[]{
                new Vector2D(-1, 0),
                new Vector2D(0, -1),
                new Vector2D(1, 0),
                new Vector2D(0, 1)
        };
        return directions[random.nextInt(directions.length)];
    }

    public static Vector2D playerInputToVector2D(String userInput) {
        int y = userInput.charAt(0);
        int x = userInput.charAt(1);
        return new Vector2D(x - 48, y - 97);
    }
}
