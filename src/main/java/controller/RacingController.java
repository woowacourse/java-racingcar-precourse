package controller;

import dto.AttemptResult;
import dto.Winners;
import model.attempt.LeftAttemptCount;
import model.car.Car;
import model.car.Cars;
import model.movement.Movement;
import view.input.InputDisplayable;
import view.output.OutputDisplayable;

import java.util.List;
import java.util.stream.Collectors;

public class RacingController {
    private final OutputDisplayable outputDisplayable;
    private final Cars cars;
    private final LeftAttemptCount leftAttemptCount;
    private final Movement movement;

    public RacingController(InputDisplayable inputDisplayable, OutputDisplayable outputDisplayable, Movement movement) {
        this.outputDisplayable = outputDisplayable;
        this.movement = movement;
        Creater creater = new Creater(inputDisplayable);
        cars = creater.createCars();
        leftAttemptCount = creater.createLeftAttemptCount();
    }

    public void run() {
        outputDisplayable.printOperationResultLetters();
        while (leftAttemptCount.isNotZero()) {
            attemptOnce();
            leftAttemptCount.decrease();
        }
        showWinners();
    }

    private void attemptOnce() {
        cars.race(movement);
        List<AttemptResult> result = cars.getAttemptResult().stream()
                .map(AttemptResult::new)
                .collect(Collectors.toList());
        outputDisplayable.showAttemptResult(result);
    }

    private void showWinners() {
        List<Car> winnerCars = cars.getWinners();
        Winners winners = new Winners(winnerCars);
        outputDisplayable.showWinners(winners);
    }
}
