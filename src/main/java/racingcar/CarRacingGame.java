package racingcar;

import view.InputView;

import java.util.Scanner;

public class CarRacingGame {
    private final Scanner scanner;

    public CarRacingGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            String carName = InputView.getCarName(scanner);
            int tryNumber = InputView.getTryNumber(scanner);
        }
    }
}
