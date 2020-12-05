/*
 * Car.java
 *
 * version 1.2
 *
 * 2020/12/05
 *
 * Copyright (c) 2020 Junhyoung Park
 */

package racingcar.domain;

public class Car implements Comparable{
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        if (Move.isMove()) {
            position++;
        }
    }

    public int compareTo(Object object) {
        Car car = (Car) object;
        return car.getPosition() - this.getPosition();
    }
}
