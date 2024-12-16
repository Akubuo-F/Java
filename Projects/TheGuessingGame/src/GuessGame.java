import java.util.Random;
public class GuessGame {

    public void startGame() {
        Player[] players = createPlayers();

        int bound = 10;
        System.out.println("I'm thinking of a number between 0 and " + (bound - 1) + "...");
        int target = generateTarget(bound);
        System.out.println("Number to guess is " + target);

        boolean areThereWinners = false;
        while (!areThereWinners) {
            for (Player player : players) {
                int playerGuess = player.guessNumber(bound);
                if (playerGuess == target) {
                    areThereWinners = true;
                }
            }
            for (Player player : players) {
                displayPlayerGuessMessage(player.getPlayer_id(), player.getCurrent_guess());
            }
            if (!areThereWinners) {
                displayNoWinnerMessage();
            } else {
                displayWinnersMessage(players, target);
            }
        }
        displayGameOverMessage();
    }

    private Player[] createPlayers() {
        return new Player[]{new Player(1), new Player(2), new Player(3)};
    }

    private int generateTarget(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    private void displayWinnersMessage(Player[] players, int target) {
        String message = "We have a winner!";
        System.out.println(message);

        for (Player player : players) {
            boolean gotItRight = player.getCurrent_guess() == target;
            String gotItRightMessage = "Player " + player.getPlayer_id() + " got it right? " + gotItRight;
            System.out.println(gotItRightMessage);
        }
    }

    private void displayPlayerGuessMessage(int player_id, int playerGuess) {
        String message = "Player " + player_id + " guessed " + playerGuess;
        System.out.println(message);
    }

    private void displayNoWinnerMessage() {
        System.out.println("Players will have to try again.");
    }

    private void displayGameOverMessage() {
        System.out.println("Game is over.");
    }
}