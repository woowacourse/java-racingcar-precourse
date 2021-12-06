package racingcar.domain;

import java.util.List;
import racingcar.exception.RacingGameCannotGetWinnersException;

public class RacingGame {

    private final Cars cars;
    private final Round round;

    public RacingGame(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public void race() {
        round.decreaseRound();
        cars.moveAllCars();
    }

    public List<Car> cars() {
        return cars.cars();
    }

    public boolean isFinished() {
        return round.isFinished();
    }

    public List<String> winners() {
        checkCanGetWinners();
        return cars.getWinners();
    }

    private void checkCanGetWinners() {
        if (!isFinished()) {
            throw new RacingGameCannotGetWinnersException();
        }
    }
}
