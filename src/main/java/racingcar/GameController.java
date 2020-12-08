package racingcar;

import java.util.Scanner;

public class GameController implements IController {
    private final IRacingGame game;
    private final Scanner scanner;

    public GameController(IRacingGame game, Scanner scanner) {
        this.game = game;
        this.scanner = scanner;
    }

    @Override
    public void setUp() {
        do {
            game.readyForSetCars();
        } while (!game.trySetCars(scanner.nextLine()));
    }

    @Override
    public void run() {
    }
}
