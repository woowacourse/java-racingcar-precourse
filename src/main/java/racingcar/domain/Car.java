package racingcar.domain;

import java.util.stream.IntStream;

public class Car implements Comparable<Car> {
    public static final String DELIMITER = " : ";
    public static final int START_INDEX = 0;
    public static final String STRING_POSITION = "-";
    public static final int SAME_POSITION = 0;
    public static final int HIGHER_POSITION = 1;
    public static final int LOWER_POSITION = -1;

    private final String name;
    private int position = 0;

    public Car(String name) { this.name = name; }

    public void move() {
        position++;
    }

    public int getPosition() {
        return this.position;
    }

    public String getRecord() {
        return name + DELIMITER + report(position);
    }

    private String report(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(START_INDEX, position).forEach(i -> stringBuilder.append(STRING_POSITION));
        return stringBuilder.toString();
    }

    public boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }

    @Override
    public int compareTo(Car car) {
        if (this.position > car.getPosition()) {
            return HIGHER_POSITION;
        }
        if (this.position < car.getPosition()) {
            return LOWER_POSITION;
        }
        return SAME_POSITION;
    }

    @Override
    public String toString() {
        return name;
    }
}
