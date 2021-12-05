package racingcar.domain;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private Round round;

    public RacingGame(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public void race() {
        round.decreaseRound();
        cars.move();
    }

    public List<Car> cars() {
        return cars.cars();
    }

    public boolean isFinished() {
        return round.isFinished();
    }
}
