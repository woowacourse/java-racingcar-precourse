package racingcar;

import utils.RandomUtils;

import java.util.Objects;

public class Car implements Comparable<Car>{
    private static final int SINGLE_DIGIT_MIN = 0;
    private static final int SINGLE_DIGIT_MAX = 9;
    private static final int STOP_LIMIT = 3;
    private static final String POSITION_BAR = "-";

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Car) {
            Car anotherCar = (Car) object;
            return name.equals(anotherCar.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void moveCar() {
        if (isPossibleMove()) {
            position++;
        }
    }

    private boolean isPossibleMove() {
        int movementState = RandomUtils.nextInt(SINGLE_DIGIT_MIN, SINGLE_DIGIT_MAX);
        return movementState > STOP_LIMIT;
    }

    @Override
    public String toString() {
        return name + " : " + POSITION_BAR.repeat(position);
    }

    @Override
    public int compareTo(Car car) {
        return car.position - this.position;
    }

    public boolean isWinner(Car maxPositionCar) {
        return this.position == maxPositionCar.position;
    }

    public String getName() {
        return this.name;
    }

}
