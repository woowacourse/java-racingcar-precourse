package com.woowacourse.two;

public class Car {
    private final String name;
    private int position = 0;
    private String distance = "";

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public String getDistance() {
        return this.distance;
    }

    public void movePosition() {
        this.position++;
        this.distance += "-";
    }
}
