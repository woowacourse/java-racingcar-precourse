package racingcar;

import java.util.*;

public class Race {
    private final InputManager inputManager = new InputManager();

    private final List<Car> cars = new ArrayList<>();
    private int tryCount;

    public Race() {
        initCars();
        setTryCount();
    }

    public void play() {
        Game game = new Game(cars, tryCount);
        game.play();
    }

    private void initCars() {
        for (String name : inputManager.getCarNames()) {
            cars.add(new Car(name));
        }
    }

    private void setTryCount() {
        tryCount = inputManager.getTryCount();
    }
}
