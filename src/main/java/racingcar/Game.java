package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final User user;
    private final List<Car> cars;

    public Game() {
        user = new User();
        cars = new ArrayList<>();
    }

    public void setRacingCarList() {
        user.setCarNames()
                .forEach(carName -> cars.add(new Car(carName)));
    }
}
