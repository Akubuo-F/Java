public interface UI {

    public String getPlayerGuess();
    public void displayAttackMessage(AttackMessage message, String startUpShipName);
    public void displayGameOverMessage(int playerRating);
    public void close();
}
