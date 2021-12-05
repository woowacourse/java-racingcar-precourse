package controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import model.attempt.LeftAttemptCount;
import model.car.Cars;
import model.movement.Movement;
import model.movement.RandomMovement;
import view.input.InputDisplayable;
import view.input.InputView;
import view.output.OutputDisplayable;
import view.output.OutputView;
import dto.AttemptResult;

public class RacingController {
    private final InputDisplayable inputDisplayable = new InputView();
    private final OutputDisplayable outputDisplayable = new OutputView();
    private Cars cars;
    private LeftAttemptCount leftAttemptCount;

    public RacingController() {
        createCars();
        createLeftAttemptCount();
    }

    private void createCars() {
        boolean isWrongNames = true;
        while (isWrongNames) {
            inputDisplayable.alertInputNames();
            List<String> carNames = Arrays.stream(readLine().split(",")).collect(Collectors.toList());
            try {
                cars = new Cars(carNames);
                isWrongNames = false;
            } catch (Exception exception) {
                inputDisplayable.printErrorMessage(exception.getMessage());
            }
        }
    }

    private void createLeftAttemptCount() {
        boolean isWrongCount = true;
        while (isWrongCount) {
            inputDisplayable.alertInputCountOfAttempt();
            String attemptCountInput = readLine();
            try {
                leftAttemptCount = new LeftAttemptCount(attemptCountInput);
                isWrongCount = false;
            } catch (Exception exception) {
                inputDisplayable.printErrorMessage(exception.getMessage());
            }
        }
    }

    public void run() {
        Movement randomMovement = new RandomMovement();
        outputDisplayable.printOperationResultLetters();
        while (leftAttemptCount.isNotZero()) {
            attemptOnce(randomMovement);
            leftAttemptCount.decrease();
        }
        outputDisplayable.showWinners(cars.getWinners());
    }

    private void attemptOnce(final Movement randomMovement) {
        cars.race(randomMovement);
        List<AttemptResult> result = cars.getAttemptResult().stream()
                .map(AttemptResult::new)
                .collect(Collectors.toList());
        outputDisplayable.showAttemptResult(result);
    }
}
