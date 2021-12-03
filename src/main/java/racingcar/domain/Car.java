package racingcar.domain;

import java.util.stream.IntStream;

public class Car implements Comparable<Car> {
    public static final String DELIMITER = " : ";
    public static final int START_INDEX = 0;
    public static final String STRING_POSITION = "-";

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

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

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(this.position, car.getPosition());
    }

    @Override
    public String toString() {
        return name;
    }
}
