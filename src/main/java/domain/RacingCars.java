package domain;

import java.util.*;
import java.util.stream.*;

public class RacingCars {
    private static final int MAXIMUM_LENGTH_OF_CAR_NAME = 5;
    private static final int MINIMUM_NUMBER_OF_CARS = 1;
    private static final int STRIDE_LENGTH = 1;
    private static final String MESSAGE_RACE_END = "가 최종 우승했습니다.";

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        validateNames(cars);
        validateSize(cars);
        this.cars = cars;
    }

    private void validateNames(List<Car> cars) {
        for (Car car : cars) {
            validateName(car);
        }
    }

    private void validateName(Car car) {
        if (car.hasNameLongerThan(MAXIMUM_LENGTH_OF_CAR_NAME)) {
            throw new IllegalArgumentException("각 자동차의 이름은 5자 이하만 가능합니다.");
        }
    }

    private void validateSize(List<Car> cars) {
        if (cars.size() < MINIMUM_NUMBER_OF_CARS) {
            throw new IllegalArgumentException("자동차는 최소 1대가 필요합니다.");
        }
    }

    public void updateCars() {
        for (Car car : cars) {
            updateCar(car);
        }
    }

    private void updateCar(Car car) {
        if (shouldMove()) {
            car.moveForward(STRIDE_LENGTH);
        }
    }

    private boolean shouldMove() {
        Random random = new Random();
        // 60% 확률로 참값을 반환함
        return random.nextInt(10) >= 4;
    }

    private int getMaxDistance() {
        return cars.stream()
                   .mapToInt(Car::getPosition)
                   .max()
                   .getAsInt();
    }

    private List<String> getWinners() {
        int maxDistance = getMaxDistance();
        return cars.stream()
                   .filter(car -> car.isMaxPosition(maxDistance))
                   .map(Car::getName)
                   .collect(Collectors.toList());
    }

    public void printWinners() {
        List<String> winners = getWinners();
        String result = String.join(", ", winners);
        System.out.println(result + MESSAGE_RACE_END);
    }

    public void printStatus() {
        for (Car car : cars) {
            System.out.println(car.getStatus());
        }
        System.out.println();
    }
}
