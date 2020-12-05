package racingcar;

import java.util.List;

public class Race {
    private List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public static Race generateRace(InputManager inputManager) {
        while (true) {
            try {
                return new Race(inputManager.generateCars());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void startCarRace(int trialCount) {
        for (int i=0; i<trialCount; i++) {
            for (Car car : cars) {
                car.moveCar();
            }
        }
    }
}
