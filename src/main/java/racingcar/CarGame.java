package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarGame {

    private final List<Car> cars;
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
            throw new IllegalArgumentException(Message.NUMBER_OF_CARS_VALIDATION);
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
            throw new IllegalArgumentException(Message.MOVE_COUNTS_VALIDATION);
        }
    }

    public void startRacing() {
        if (checkIsOver()) {
            throw new IllegalStateException(Message.GAME_OVER);
        }
        for (Car car : cars) {
            car.moveOrStop(getRandomFuel());
        }
        moveCounts--;
    }

    public boolean checkIsOver() {
        return moveCounts <= 0;
    }

    private int getRandomFuel() {
        return Randoms.pickNumberInRange(Car.MIN_FUEL, Car.MAX_FUEL);
    }

    public List<String> announceWinners() {
        return cars.stream()
            .filter(car -> car.getCurrentPosition() == cars.stream().map(Car::getCurrentPosition)
                .max(Integer::compareTo).orElse(0))
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}
