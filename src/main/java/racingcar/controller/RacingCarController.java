package racingcar.controller;

import racingcar.domain.AttemptNumber;
import racingcar.domain.Cars;
import racingcar.domain.ForwardingChecker;
import racingcar.domain.WinnerChecker;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class RacingCarController {
    private final InputView inputView;
    private Cars cars;
    private AttemptNumber attemptNumber;

    public RacingCarController(Scanner scanner) {
        this.inputView = new InputView(scanner);
    }

    public void requestCarNames() {
        OutputView.printRequestCarNamesMessage();
        List<String> carNames = inputView.inputCarNames();
        this.cars = Cars.generate(carNames);
    }

    public void requestAttemptNumber() {
        OutputView.printRequestAttemptNumberMessage();
        String inputAttempNumber = inputView.inputAttemptNumber();
        this.attemptNumber = new AttemptNumber(inputAttempNumber);
    }

    public void runGame() {
        OutputView.printExecutionResultMessage();
        while (attemptNumber.isRemain()) {
            ForwardingChecker.run(cars);
            attemptNumber.decrease();
            OutputView.printExecutionResult(cars);
        }
    }

    public void determineWinner() {
        Cars winners = WinnerChecker.run(cars);
        OutputView.printFinalWinners(winners);
    }
}
