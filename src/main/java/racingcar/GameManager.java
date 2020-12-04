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
        int moveCount = inputHandler.askMoveCount();
        
        OutputHandler.printRunMessage();
        move(moveCount);
    }

    private void move(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            cars.moveAllCars();
            OutputHandler.printCarList(cars);
        }
    }
}
