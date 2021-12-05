package controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import model.attempt.LeftAttemptCount;
import model.car.Cars;
import model.movement.Movement;
import model.movement.RandomMovement;
import view.InputView;
import view.OutputView;

public class RacingController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Cars cars;
    private LeftAttemptCount leftAttemptCount;

    public RacingController() {
        createCars();
        createLeftAttemptCount();
    }

    private void createCars() {
        boolean isWrongNames = true;
        while (isWrongNames) {
            inputView.alertInputNames();
            List<String> carNames = Arrays.stream(readLine().split(",")).collect(Collectors.toList());
            try {
                cars = new Cars(carNames);
                isWrongNames = false;
            } catch (Exception exception) {
                inputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private void createLeftAttemptCount() {
        boolean isWrongCount = true;
        while (isWrongCount) {
            inputView.alertInputCountOfAttempt();
            String attemptCountInput = readLine();
            try {
                leftAttemptCount = new LeftAttemptCount(attemptCountInput);
                isWrongCount = false;
            } catch (Exception exception) {
                inputView.printErrorMessage(exception.getMessage());
            }
        }
    }
    public void run() {
        Movement randomMovement = new RandomMovement();
        outputView.printOperationResultLetters();
        while (leftAttemptCount.isNotZero()) {
            attemptOnce(randomMovement);
            leftAttemptCount.decrease();
        }
        outputView.showWinners(cars.getWinners());
    }

    private void attemptOnce(final Movement randomMovement) {
        cars.race(randomMovement);
        outputView.showAttemptResult(cars.getAttemptResult());
    }
}
