package racingcar;
/*
 * Car
 *
 * version 1.0
 *
 * 2020.12.05
 *
 * Copyright (c) by Davinci.J
 */
import utils.RandomUtils;

import java.util.Objects;

public class Car implements Comparable<Car>{
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

    @Override
    public String toString() {
        return name + " : " + Constants.POSITION_BAR.repeat(position);
    }

    @Override
    public int compareTo(Car car) {
        return car.position - this.position;
    }

    public void moveCar() {
        if (isPossibleMove()) {
            position++;
        }
    }

    private boolean isPossibleMove() {
        int movementState = RandomUtils.nextInt(Constants.SINGLE_DIGIT_MIN,
                                                    Constants.SINGLE_DIGIT_MAX);
        return movementState > Constants.STOP_LIMIT;
    }

    public boolean isWinner(Car maxPositionCar) {
        return this.position == maxPositionCar.position;
    }

    public String getName() {
        return this.name;
    }

}
