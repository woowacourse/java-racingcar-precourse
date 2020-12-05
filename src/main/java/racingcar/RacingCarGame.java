package racingcar;

import racingcar.domain.AttemptNumber;
import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Scanner;

public class RacingCarGame {
    private final Scanner scanner;

    public RacingCarGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        Cars cars = InputView.inputCarNames(scanner);
        AttemptNumber attemptNumber = InputView.inputAttemptNumber(scanner);
        attemptNumber.moveOrStopByAttemptNumber(cars);
        Winners winners = cars.getWinnerCars();
        OutputView.printWinnerNames(winners);
    }
}
