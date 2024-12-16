package circleanimationapp;

import java.awt.*;
import java.util.Random;

public class Util {
    private static final Random randomer = new Random();

    public static Color generateRandomColor() {
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);

        return new Color(r, g, b);
    }

    public static int randomInt(int bound) {
        return randomer.nextInt(bound);
    }
}
