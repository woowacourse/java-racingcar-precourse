package game;

import static game.Message.RESULT_MESSAGE;
import static game.Message.print;

import java.util.List;
import racingcar.Car;
import racingcar.Cars;
import racingcar.Winner;

/**
 * @author yhh1056
 * @since 2020/12/03
 */
public class RacingGame {
    private Cars cars;

    public RacingGame(final List<Car> cars) {
        this.cars = new Cars(cars);
    }

    public void startRace(final int gameCount) {
        print(RESULT_MESSAGE);
        cars.moves(gameCount);
    }

    public Winner findWinners() {
        return new Winner(cars);
    }
}
