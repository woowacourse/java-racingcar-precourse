/*
 * Car.java
 *
 * version 1.0
 *
 * 2020/12/04
 *
 * Copyright (c) 2020 Junhyoung Park
 */

package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        position += 1;
        return position;
    }
}
