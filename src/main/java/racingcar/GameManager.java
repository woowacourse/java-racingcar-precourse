package racingcar;

import java.util.Scanner;

public class GameManager {
    private Scanner scanner;
    private CarList cars;

    public GameManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        InputHandler inputHandler = new InputHandler(scanner);
        String[] carNames = inputHandler.askCarNames();
        cars = new CarList(carNames);
    }
}
