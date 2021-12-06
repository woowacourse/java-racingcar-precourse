package controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import model.attempt.LeftAttemptCount;
import model.car.Cars;
import view.input.InputDisplayable;

public class Creater {
    private final InputDisplayable inputDisplayable;
    private Cars cars;
    private LeftAttemptCount leftAttemptCount;
    private boolean wrongInput;

    public Creater(final InputDisplayable inputDisplayable) {
        this.inputDisplayable = inputDisplayable;
    }

    public Cars createCars() {
        wrongInput = true;
        while (wrongInput) {
            inputAndCreateCars();
        }
        return cars;
    }

    private void inputAndCreateCars() {
        inputDisplayable.alertInputNames();
        List<String> carNames = Arrays.stream(readLine().split(",")).collect(Collectors.toList());
        try {
            cars = new Cars(carNames);
            wrongInput = false;
        } catch (Exception exception) {
            inputDisplayable.printErrorMessage(exception.getMessage());
        }
    }

    public LeftAttemptCount createLeftAttemptCount() {
        wrongInput = true;
        while (wrongInput) {
            inputAndCreateLeftAttemptCount();
        }
        return leftAttemptCount;
    }

    private void inputAndCreateLeftAttemptCount() {
        inputDisplayable.alertInputCountOfAttempt();
        String attemptCountInput = readLine();
        try {
            leftAttemptCount = new LeftAttemptCount(attemptCountInput);
            wrongInput = false;
        } catch (Exception exception) {
            inputDisplayable.printErrorMessage(exception.getMessage());
        }
    }
}
