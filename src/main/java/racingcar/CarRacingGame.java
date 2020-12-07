package racingcar;

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
        playAllRound(tryNumber, racingCars);
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

    private void playAllRound(int tryNumber, Car[] racingCars) {
        OutputView.showAllRoundResultMessage();
        for (int i = 0; i < tryNumber; i++) {
            playOneRound(racingCars);
            System.out.println();
        }
        OutputView.showWinner(racingCars);
    }

    private void playOneRound(Car[] racingCars) {
        for (Car racingCar : racingCars) {
            if (racingCar.makeRandomNumber() >= MOVE_FORWARD) {
                racingCar.move();
            }
            OutputView.showOneRoundResult(racingCar);
        }
    }
}
