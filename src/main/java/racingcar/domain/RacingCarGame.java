package racingcar.domain;

import racingcar.exception.RacingCarException;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.Scanner;

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
            GameRule.printRacingWinners(cars);
        } catch (RacingCarException e) {
            OutputView.printErrorLog(e.getMessage());
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
}
