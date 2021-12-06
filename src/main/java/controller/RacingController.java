package controller;

import dto.AttemptResult;
import dto.Winners;
import model.attempt.LeftAttemptCount;
import model.car.Car;
import model.car.Cars;
import model.movement.Movement;
import model.movement.RandomMovement;
import view.input.InputDisplayable;
import view.input.InputView;
import view.output.OutputDisplayable;
import view.output.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingController {
    private final OutputDisplayable outputDisplayable = new OutputView();
    private final Cars cars;
    private final LeftAttemptCount leftAttemptCount;

    public RacingController() {
        InputDisplayable inputDisplayable = new InputView();
        Creater creater = new Creater(inputDisplayable);
        cars = creater.createCars();
        leftAttemptCount = creater.createLeftAttemptCount();
    }

    public void run() {
        Movement randomMovement = new RandomMovement();
        outputDisplayable.printOperationResultLetters();
        while (leftAttemptCount.isNotZero()) {
            attemptOnce(randomMovement);
            leftAttemptCount.decrease();
        }
        showWinners();
    }

    private void showWinners() {
        List<Car> winnerCars = cars.getWinners();
        Winners winners = new Winners(winnerCars);
        outputDisplayable.showWinners(winners);
    }

    private void attemptOnce(final Movement randomMovement) {
        cars.race(randomMovement);
        List<AttemptResult> result = cars.getAttemptResult().stream()
                .map(AttemptResult::new)
                .collect(Collectors.toList());
        outputDisplayable.showAttemptResult(result);
    }
}
