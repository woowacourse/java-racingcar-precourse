package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.ErrorCode.NOT_VALID_CARS_COUNT;
import static racingcar.ErrorCode.NOT_VALID_CARS_DUPLICATED;

public class RacingCarGame {
    private List<Car> cars;

    public RacingCarGame(List<String> cars) {
        validateCarCount(cars);
        validateCarDuplication(cars);
        setCars(cars);
    }

    public void setCars(List<String> carNames) {
        cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void raceCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    //게임 결과
    public List<String> getMovingResult() {
        List<String> movingResult = new ArrayList<>();

        for (Car car : cars) {
            movingResult.add(car.getNameAndPosition());
        }

        return movingResult;
    }

    public List<String> getWinningCars() {
        Car maxPositionCar = getMaxPositionCar();
        return cars.stream()
                .filter(car -> car.compareTo(maxPositionCar) == 0)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public Car getMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("비교할 차량이 없습니다."));
    }

    public void validateCarCount(List<String> cars) {
        if (cars.size() < 2) {
            NOT_VALID_CARS_COUNT.throwError();
        }
    }

    public void validateCarDuplication(List<String> cars) {
        if(new HashSet<>(cars).size() != cars.size()) {
            NOT_VALID_CARS_DUPLICATED.throwError();
        }
    }

}
