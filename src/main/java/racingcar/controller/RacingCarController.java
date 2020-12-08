package racingcar.controller;

import racingcar.domain.AttemptNumber;
import racingcar.domain.Cars;
import racingcar.domain.ForwardingChecker;
import racingcar.domain.WinnerChecker;
import racingcar.utils.CarNamesConverter;
import racingcar.validator.CarNamesInputValidator;
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
        while (!isValidRequestCarNames()) ;
    }

    private boolean isValidRequestCarNames() {
        try {
            OutputView.printRequestCarNamesMessage();
            String carNamesInput = inputView.inputCarNames();
            CarNamesInputValidator.validate(carNamesInput);
            List<String> carNames = CarNamesConverter.convert(carNamesInput);
            this.cars = Cars.generate(carNames);
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
            return false;
        }
        return true;
    }

    public void requestAttemptNumber() {
        while (!isValidRequestAttemptNumber()) ;
    }

    private boolean isValidRequestAttemptNumber() {
        try {
            OutputView.printRequestAttemptNumberMessage();
            String inputAttempNumber = inputView.inputAttemptNumber();
            this.attemptNumber = new AttemptNumber(inputAttempNumber);
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
            return false;
        }
        return true;
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
