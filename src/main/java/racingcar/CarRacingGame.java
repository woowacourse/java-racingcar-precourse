package racingcar;

import utils.CompareUtils;
import utils.SplitUtils;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class CarRacingGame {
    private final Scanner scanner;
    private static final int MOVE_FORWARD = 4;

    public CarRacingGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        String carNames = InputView.getCarName(scanner);
        int tryNumber = InputView.getTryNumber(scanner);
        Car[] racingCars = makeRacingCars(carNames);
    }

    private Car[] makeRacingCars(String carNames) {
        String[] racingCarNames = SplitUtils.splitCarName(carNames);

        int numberOfRacingCar = racingCarNames.length;
        Car[] racingCars = new Car[numberOfRacingCar];

        for (int i = 0; i < numberOfRacingCar; i++) {
            racingCars[i] = new Car(racingCarNames[i]);
        }
        return racingCars;
    }
}
