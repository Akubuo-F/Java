import java.util.Scanner;


public class CommandLineUI implements UI{

    private final Scanner scanner = new Scanner(System.in);
    @Override
    public String getPlayerGuess() {
        System.out.print("Enter a guess ");
        return scanner.nextLine().toLowerCase();
    }

    @Override
    public void displayAttackMessage(AttackMessage message, String startUpShipName) {
        switch (message) {
            case HIT -> {
                String displayMessage = "Hit";
                System.out.println(displayMessage);
            }
            case MISS -> {
                String displayMessage = "Miss";
                System.out.println(displayMessage);
            }
            case KILL -> {
                String displayMessage = "Ouch!, You sunk " + startUpShipName + " :(";
                System.out.println(displayMessage);
            }
        }
    }

    @Override
    public void displayGameOverMessage(int playerRating) {
        String gameOverMessage = "All startups are dead!, Your Stock is now worthless";
        System.out.println(gameOverMessage);

        if (playerRating > 0 && playerRating < 15) {
            System.out.println("That was pretty quick! " + playerRating + " guesses." );
        } else if (playerRating >= 15 && playerRating < 30) {
            System.out.println("Need to be quicker than that. " + playerRating + " guesses.");
        } else if (playerRating > 30) {
            System.out.println("Took you long enough. " + playerRating + " guesses.");
        }
    }

    @Override
    public void close() {
        this.scanner.close();
    }
}
