package utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import racingcar.Car;

public class CarListUtils {
    private static final int RANDOM_MINIMUM = 1;
    private static final int RANDOM_MAXIMUM = 9;

    private CarListUtils() {}

    public static int getRandomValue() {
        return RandomUtils.nextInt(RANDOM_MINIMUM, RANDOM_MAXIMUM);
    }

    public static int getMaximumPosition(List<Car> carList) {
        return carList.stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow(NoSuchElementException::new)
                .getPosition();
    }

    public static List<String> getCarNamesAtPosition(List<Car> carList, int position) {
        List<String> carNames = new ArrayList<String>();
        for (Car car : carList) {
            if (car.getPosition() == position) {
                carNames.add(car.getName());
            }
        }

        return carNames;
    }
}
