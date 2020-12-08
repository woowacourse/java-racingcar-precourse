package racingcar;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import utils.RandomUtils;

public class Car implements Comparable<Car> {
    private static final int MINIMUM_LIMIT = 0;
    private static final int MAXIMUM_LIMIT = 9;
    private static final int MOVE_LIMIT = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveIfRandomNumberIsBiggerThanLimit() {
        if (generateRandomNumber() >= MOVE_LIMIT) {
            position++;
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.position - otherCar.position;
    }

    public boolean isSamePosition(Car otherCar) {
        return this.position == otherCar.position;
    }

    public String convertPositionToBar() {
        return Stream.generate(() -> "-")
            .limit(position)
            .collect(Collectors.joining());
    }

    protected int generateRandomNumber() {
        return RandomUtils.nextInt(MINIMUM_LIMIT, MAXIMUM_LIMIT);
    }
}
