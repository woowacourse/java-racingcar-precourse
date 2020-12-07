package racingcar.domain;

import racingcar.exception.RacingCarException;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingCarGame {
    private final InputView inputView;

    private Cars cars;
    private int round;

    public RacingCarGame(Scanner scanner) {
        this.inputView = new InputView(scanner);
    }

    public void startGame() {
        try {
            initialize();
            startRacing();
            printWinners();
        } catch (RacingCarException e) {
            System.out.println(e.getMessage());
        }
    }

    private void initialize() {
        initRacingCars();
        initRacingRound();
    }

    private void initRacingCars() {
        cars = new Cars(inputView.inputRacingCars());
    }

    private void initRacingRound() {
        this.round = inputView.inputRacingRound();
    }

    private void startRacing() {
        OutputView.printExecutionResult();
        for (int currentRound = 0; currentRound < round; currentRound++) {
            cars.racing();
        }
    }

    private void printWinners() {
        System.out.println("최종 우승자 : "
                + cars.getFastestCars()
                .stream()
                .map(car -> String.valueOf(car.getName()))
                .collect(Collectors.joining(", ")));
    }
}
