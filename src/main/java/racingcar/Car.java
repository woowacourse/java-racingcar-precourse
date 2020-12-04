package racingcar;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Car {
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
        return name + " : " + convertPositionToBar(position);
    }

    private String convertPositionToBar(int position) {
        return Stream.generate(() -> "-")
            .limit(position)
            .collect(Collectors.joining());
    }
}
