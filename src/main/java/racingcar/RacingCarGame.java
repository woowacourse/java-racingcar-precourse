package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.Rule;
import racingcar.domain.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Scanner;

public class RacingCarGame {
    private final Scanner scanner;
    private Rule rule;
    private Cars cars;

    public RacingCarGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        cars = InputView.inputCarNames(scanner);
        rule = InputView.inputAttemptNumber(scanner);
        rule.attemptMoveByAttemptNumber(cars);
        Winner winner = cars.getWinnerCars();
        OutputView.printWinner(winner);
    }
}
