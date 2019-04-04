package racingcar;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private static final int MIN_CAR_SIZE = 2;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        validateSize(cars);
        validateName(cars);
        this.cars = cars;
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();

        int maxPosition = calculateMaxPosition();

        for (Car car : cars) {
            if (maxPosition == car.getPosition())
                winners.add(car);
        }

        return winners;
    }

    private int calculateMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars)
            maxPosition = Math.max(car.getPosition(), maxPosition);

        return maxPosition;
    }

    private void validateSize(List<Car> cars) {
        if (cars.size() < MIN_CAR_SIZE)
            throw new IllegalArgumentException("자동차 이름을 " + MIN_CAR_SIZE + "개 이상 입력해주세요.");
    }

    private void validateName(List<Car> cars) {
        for (Car car : cars) {
            if (isNamePossibleLength(car))
                throw new IllegalArgumentException("자동차 이름은 " + MAX_CAR_NAME_LENGTH + "자 이하만 가능합니다.");

            if (isBlank(car))
                throw new IllegalArgumentException("자동차 이름을 공백으로 입력은 불가능합니다.");
        }
    }

    private boolean isNamePossibleLength(Car car) {
        return car.getName().length() > MAX_CAR_NAME_LENGTH;
    }

    private boolean isBlank(Car car) {
        return car.getName().equals("");
    }

    public List<Car> getCars() {
        return cars;
    }
}
