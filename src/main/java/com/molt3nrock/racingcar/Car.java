package com.molt3nrock.racingcar;

import java.util.Collections;

public class Car {

    private final static int POSITION_INCREMENT = 1;
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name.length() > 5) {
            String errorMessage = String.format("Car: %s은 너무 깁니다. 5자이내로 입력해주세요.", name);
            throw new IllegalArgumentException(errorMessage);
        }
        this.name = name;
    }

    @Override
    public String toString() {
        String dottedLine = String.join("", Collections.nCopies(position, "-"));
        return String.format("%s:%s", this.name, dottedLine);
    }
}
