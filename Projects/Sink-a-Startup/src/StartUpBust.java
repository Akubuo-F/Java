import java.util.Arrays;
import java.util.Random;


public class StartUpBust {
    private final int[][] grid;
    private final StartUpShip[] startUpShips;
    private final UI ui;

    StartUpBust (UI ui) {
        this.grid = new int[7][7];
        this.startUpShips = new StartUpShip[] {
                new StartUpShip(1, "Cabista", 3),
                new StartUpShip(2, "Poniez", 3),
                new StartUpShip(3, "Hacqi", 3)
        };
        this.ui = ui;
    }

    public void startGame() {
        placeStartUpsOnGrid();

        int playerTries = 0;
        while (!isGameOver()) {
            String playerInput = ui.getPlayerGuess();
            playerTries++;
            Vector2D playerGuess = Helper.playerInputToVector2D(playerInput);
            int id = this.grid[playerGuess.getY()][playerGuess.getX()];
            StartUpShip startUpShip = new StartUpShip(id, "?", 3);

            if (id == 0) {
                ui.displayAttackMessage(AttackMessage.MISS, startUpShip.getName());
                continue;
            }
            for (StartUpShip unknownStartUp : startUpShips) {
                if (id == unknownStartUp.getId()) {
                    startUpShip = unknownStartUp;
                }
            }
            startUpShip.decrementLive();
            this.grid[playerGuess.getY()][playerGuess.getX()] = 0;
            if (startUpShip.getLives() > 0) {
                ui.displayAttackMessage(AttackMessage.HIT, startUpShip.getName());
            } else {
                ui.displayAttackMessage(AttackMessage.KILL, startUpShip.getName());
            }
        }
        ui.displayGameOverMessage(playerTries);
        ui.close();
    }

    private void placeStartUpsOnGrid() {
        Random random = new Random();

        for (StartUpShip startUp : this.startUpShips) {
            boolean flag = true;
            while (flag) {
                int x = random.nextInt(this.grid[0].length);
                int y = random.nextInt(this.grid.length);
                Vector2D startingPoint = new Vector2D(x, y);
                Vector2D startingDirection = Helper.getRandomDirection();

                if (startUpCanFit(startingPoint, startingDirection, this.grid, startUp.getLives())) {
                    flag = false;
                    this.grid[startingPoint.getY()][startingPoint.getX()] = startUp.getId();
                    Vector2D secondPoint = startingPoint.add(startingDirection);
                    this.grid[secondPoint.getY()][secondPoint.getX()] = startUp.getId();
                    Vector2D thirdPoint = secondPoint.add(startingDirection);
                    this.grid[thirdPoint.getY()][thirdPoint.getX()] = startUp.getId();
                }
            }
        }
    }

    private boolean startUpCanFit(Vector2D startingPoint, Vector2D direction, int[][] grid, int distance) {
        boolean canFit = true;
        for (int i = 0; i < distance; i++) {
            Vector2D nextPoint = startingPoint.add(direction);
            if ((nextPoint.getY() < 0 || nextPoint.getY() > grid.length - 1) ||
                    (nextPoint.getX() < 0 || nextPoint.getX() > grid[0].length - 1) ||
                    (grid[nextPoint.getY()][nextPoint.getX()] != 0)) {
                canFit = false;
            }
            startingPoint = nextPoint.add(direction);
        }
        return canFit;
    }

    private boolean isGameOver() {
        return !isAnyStartUpAlive();
    }

    private boolean isAnyStartUpAlive() {
        for (int[] row : this.grid) {
            for (int startUpId : row) {
                if (startUpId != 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
