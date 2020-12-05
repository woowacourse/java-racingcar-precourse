package racingcar.domain.car;

import racingcar.domain.engine.DefaultEngine;
import racingcar.domain.engine.Engine;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final String name;
    private int position = 0;
    private Engine engine = new DefaultEngine();

    private static final char POSITION_MARK = '-';


    private Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    public static Car createNameBy(String name) {

        return new Car(name);
    }

    public void changeEngine(Engine engine) {
        this.engine = engine;
    }

    private String getName() {
        return name;
    }

    private int getPosition() {
        return position;
    }


    public void move() {
        position += engine.getPower();
    }

    public boolean isBigOrEqualThen(Car car) {
        if (this.compareTo(car) >= 0) {
            return true;
        }
        return false;
    }

    public String getCurrentPosition() {
        return String.format("%s : %s", name, getPositionMarks());
    }

    private String getPositionMarks() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < position; i++) {
            stringBuilder.append(POSITION_MARK);
        }

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getPositionMarks() == car.getPositionMarks() &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, getPositionMarks());
    }


    @Override
    public int compareTo(Car o) {
        return position - o.getPosition();
    }

}
