package racingcar.domain;

import java.util.List;
import racingcar.NumberGenerator;

public class RacingGame {

    private final Cars cars;
    private final CountOfMoves countOfMoves;

    public RacingGame(Cars cars, CountOfMoves countOfMoves) {
        this.cars = cars;
        this.countOfMoves = countOfMoves;
    }

    public List<Car> move(NumberGenerator numberGenerator) {
        cars.play(numberGenerator);
        countOfMoves.upperCurrentRound();
        return cars.getCars();
    }

    public boolean isOver() {
        return countOfMoves.reachTargetNumber();
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }
}
