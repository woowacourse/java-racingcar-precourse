package racingcar;

import java.util.Scanner;

public class RacingCarGame {

    private final Scanner scanner;

    RacingCarGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public Car[] getCars() {
        InputView inputView = new InputView(scanner);
        String[] carNames = inputView.getCarList();
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }
}
