package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final User user;
    private final List<Car> cars;
    private int attemptCounts;

    public Game() {
        user = new User();
        cars = new ArrayList<>();
        attemptCounts = 0;
    }

    public void setRacingCarList() {
        user.setCarNames()
                .forEach(carName -> cars.add(new Car(carName)));
    }

    public void setAttemptCounts() {
        attemptCounts = user.setAttemptCounts();
    }
}
