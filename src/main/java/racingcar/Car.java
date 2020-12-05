package racingcar;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Car implements Comparable<Car>{
    private final String name;
    private int position = 0;
    private int MOVE_LIMIT = 4;

    public Car(String name) {
        this.name = name;
    }

    public void moveIfRandomNumberIsBiggerThanLimit(int randomNumber) {
        if (randomNumber > MOVE_LIMIT) {
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

    public boolean isSamePosition(Car otherCar){
        return this.position == otherCar.position;
    }

    public String convertPositionToBar() {
        return Stream.generate(() -> "-")
            .limit(position)
            .collect(Collectors.joining());
    }
}
