package domain;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class Cars {
    private static final String DELIMITER = ",";
    private static final String BLANK = " ";
    private static final int MAX_OF_RANDOM_NUMBER = 9;
    private static final int MIN_OF_PROCEEDING_NUMBER = 4;

    private List<Car> cars;

    public Cars(String carNames) {
        this.cars = Arrays.stream(carNames.split(DELIMITER))
                .map(Car::new)
                .collect(Collectors.toList());
        validateDuplication(this.cars);
    }

    private static void validateDuplication(List<Car> cars) {
        long distinctCarsCount = cars.stream()
                .map(Car::getName)
                .distinct()
                .count();
        if (cars.size() != distinctCarsCount) {
            throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다.");
        }

    }

    public void play() {
        for (Car car : cars) {
            if (canProceed(getRandomNumber())) {
                car.proceed();
            }
        }
    }

    public void printPositions() {
        for (Car car : cars) {
            car.printPosition();
        }
    }

    private int getRandomNumber() {
        return new Random().nextInt(MAX_OF_RANDOM_NUMBER + 1);
    }

    private boolean canProceed(int randomNumber) {
        return randomNumber >= MIN_OF_PROCEEDING_NUMBER;
    }

    public String getMaxPositionCars() {
        return this.cars.stream()
                .filter(car -> car.isSamePosition(getMaxPosition()))
                .map(Car::getName)
                .collect(joining(DELIMITER + BLANK));
    }

    private int getMaxPosition() {
        return this.cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .map(Car::getPosition)
                .get();
    }
}