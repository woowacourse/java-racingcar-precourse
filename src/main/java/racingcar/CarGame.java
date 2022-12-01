package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarGame {

    private List<Car> cars;
    private int moveCounts;

    public CarGame() {
        cars = new ArrayList<>();
    }

    public void registerCar(List<String> cars) {
        validateCars(cars);
        for (String carName : cars) {
            this.cars.add(new Car(carName));
        }
    }

    private void validateCars(List<String> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("등록할 자동차는 최소 1대여야 합니다.");
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void registerMoveCounts(int moveCounts) {
        validateMoveCounts(moveCounts);
        this.moveCounts = moveCounts;
    }

    private void validateMoveCounts(int moveCounts) {
        if (moveCounts <= 0) {
            throw new IllegalArgumentException("이동횟수는 최소 1회 이상이어야 합니다.");
        }
    }
}
