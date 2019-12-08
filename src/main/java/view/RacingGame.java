package view;

import domain.car.Car;
import domain.car.RacingCars;
import domain.car.engine.RandomEngine;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class RacingGame {

    private final RacingCars racingCars;
    private final int count;

    private RacingGame(RacingCars racingCars, int count) {
        validateCount(count);
        this.racingCars = racingCars;
        this.count = count;
    }

    public static RacingGame newGame() {
        RacingCars racingCars = makeRacingCars();
        int count = InputView.inputGameCount();
        return new RacingGame(racingCars, count);
    }

    private static RacingCars makeRacingCars() {
        List<String> names = InputView.inputCarNames();
        List<Car> cars = names.stream()
                .map(Car::new)
                .collect(toList());
        return new RacingCars(cars);
    }

    private void validateCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("0보다 큰수를 입력히세요.");
        }
    }

    public void run() {
        for (int i = 0; i < count; i++) {
            racingCars.move(new RandomEngine());
            OutputView.showRacingCars(racingCars);
        }
        OutputView.showWinners(racingCars.getWinningCars());
    }

}
