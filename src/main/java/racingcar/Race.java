package racingcar;

import java.util.List;

public class Race {
    private List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public static Race generateRace(InputManager inputManager) {
        return new Race(inputManager.generateCars());
    }
}
