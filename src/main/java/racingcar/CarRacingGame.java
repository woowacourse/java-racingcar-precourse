package racingcar;

import view.InputView;

import java.util.Scanner;

public class CarRacingGame {
    private final Scanner scanner;

    public CarRacingGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        String carName = InputView.getCarName(scanner);
        System.out.println(carName);
        int tryNumber = InputView.getTryNumber(scanner);
    }
}
