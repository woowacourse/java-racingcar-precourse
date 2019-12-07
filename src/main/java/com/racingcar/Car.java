package com.racingcar;

/**
 * Car
 *
 * @author hyochan
 * @version 0.0.1
 * @since 2019-12-06
 */


public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void advance() {
        this.position += 1;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
