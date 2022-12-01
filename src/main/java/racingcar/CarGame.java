package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarGame {

    private List<Car> cars;

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
}
