package racingcar;

import static racingcar.Message.RESULT_MESSAGE;

import java.util.List;

/**
 * @author yhh1056
 * @since 2020/12/03
 */
public class RacingGame {
    private Cars cars;

    public RacingGame(List<Car> cars) {
        this.cars = new Cars(cars);
    }

    public void startRace(int gameCount) {
        System.out.println(RESULT_MESSAGE);
        cars.moves(gameCount);
    }

    public List<String> findWinners() {
        return cars.findWinners();
    }
}
