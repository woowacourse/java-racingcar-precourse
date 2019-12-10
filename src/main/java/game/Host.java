package game;

import domain.Car;
import exception.InvalidInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Host {

    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int DEFAULT_POSITION = 0;
    private static final int MINIMUM_SIZE = 2;
    private static final String CAR_NAME_FORMAT = "%" + Car.CAR_NAME_LENGTH_LIMIT + "s:";
    private static final String CAR_POSITION_MARK = "-";

    private List<Car> cars;

    public Host(List<String> names) {
        validatesMinimumSize(names);
        validatesDuplicateNames(names);

        cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    private void validatesMinimumSize(List<String> names) {
        if (names.size() < MINIMUM_SIZE) {
            throw new InvalidInputException(InvalidInputException.NAMES_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private void validatesDuplicateNames(List<String> names) {
        if (names.stream().distinct().count() != names.size()) {
            throw new InvalidInputException(InvalidInputException.NAME_DUPLICATION_EXCEPTION_MESSAGE);
        }
    }
    public void runOneTime(Random random) {
        for (Car car : cars) {
            car.proceedOrStop(generateRandomNumber(random));
        }
    }

    private int generateRandomNumber(Random random) {
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }

    public void showCarsStatus() {
        for (Car car : cars) {
            System.out.println(makeCarStatus(car));
        }
    }

    private String makeCarStatus(Car car) {
        String name = car.getName();
        int position = car.getPosition();
        StringBuilder result = new StringBuilder();

        result.append(String.format(CAR_NAME_FORMAT, name));
        for (int i = 0; i < position; i++) {
            result.append(CAR_POSITION_MARK);
        }

        return result.toString();
    }

    public int measureFirstPosition() {
        int first = DEFAULT_POSITION;
        for (Car car : cars) {
            if (car.getPosition() > first) {
                first = car.getPosition();
            }
        }
        return first;
    }

    public List<Car> takeCarsInFirstPosition(int position) {
        List<Car> carsInFirstPosition = new ArrayList<>();
        for (Car car : cars) {
            if (car.isSamePosition(position)) {
                carsInFirstPosition.add(car);
            }
        }
        return carsInFirstPosition;
    }

}
