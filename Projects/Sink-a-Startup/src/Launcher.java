public class Launcher {

    public static void main(String[] args) {
        UI commandLineUI = new CommandLineUI();
        StartUpBust startUpBust = new StartUpBust(commandLineUI);
        startUpBust.startGame();
    }
}
