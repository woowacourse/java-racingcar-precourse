package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final List<Car> cars;
    private int tryCount;

    private final InputManager inputManager = new InputManager();
    private final OutputManager outputManager = new OutputManager();

    public Game() {
        cars = new ArrayList<>();

        initCars();
        initTryCount();
    }

    public void play() {
        for (int i = 0; i < tryCount; i++) {
            moveOneRound();
        }

        List<String> winnerNames = getWinnerNames();

        outputManager.printWinnerNames(winnerNames);
    }

    private void initCars() {
        for (String name : inputManager.getCarNames()) {
            cars.add(new Car(name));
        }
    }

    private void initTryCount() {
        tryCount = inputManager.getTryCount();
    }

    private void moveOneRound() {
        for (Car car: cars) {
            car.move();
            outputManager.printCurrentCarPosition(car);
        }

        outputManager.printRoundSplitter();
    }

    private List<String> getWinnerNames() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(x -> x.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        int max = 0;
        int currentPosition;

        for (Car car : cars) {
            currentPosition = car.getPosition();

            if (max < currentPosition) max = currentPosition;
        }

        return max;
    }
}
