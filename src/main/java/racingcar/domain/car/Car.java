package racingcar.domain.car;

import racingcar.domain.engine.DefaultEngine;
import racingcar.domain.engine.Engine;
import racingcar.domain.setting.Message;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final String name;
    private int position = 0;
    private Engine engine;

    private Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    public Car(String name, Engine engine) {
        this.name = name;
        this.engine = engine;
    }

    public static Car create(String name, Engine engine) {

        return new Car(name, engine);
    }

    public static Car createNameBy(String name) {

        return new Car(name, new DefaultEngine());
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

    public boolean atFirstPosition(Car car) {
        if (this.compareTo(car) == 0) {
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
            stringBuilder.append(Message.POSITION_MARK);
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
        return getPosition() == ((Car) o).getPosition() &&
                getName().equals(((Car) o).getName());
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
