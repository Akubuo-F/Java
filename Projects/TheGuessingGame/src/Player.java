import java.util.Random;

public class Player {
    private final int player_id;
    private int current_guess;

    Player(int player_id) {
        this.player_id = player_id;
    }

    public int getPlayer_id() {
        return this.player_id;
    }

    public int getCurrent_guess() {
        return this.current_guess;
    }

    public int guessNumber(int bound) {
        Random random = new Random();
        int guess = random.nextInt(bound);
        this.current_guess = guess;
        String guessingMessage = "I'm guessing " + guess;
        System.out.println(guessingMessage);
        return guess;
    }
}
