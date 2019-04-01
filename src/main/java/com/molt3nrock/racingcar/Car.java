package com.molt3nrock.racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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


    public void move() {
        final int VALID_RANDOM_MIN = 0;
        final int VALID_RANDOM_MAX = 9;
        final int MOVE_THRESHOLD = 4;
        ArrayList<Integer> randoms = IntStream
            .range(VALID_RANDOM_MIN, VALID_RANDOM_MAX)
            .boxed()
            .collect(Collectors.toCollection(ArrayList::new));
        Collections.shuffle(randoms);
        Integer pick = randoms.get(0);
        if (pick >= MOVE_THRESHOLD) {
            position += POSITION_INCREMENT;
        }
    }

    @Override
    public String toString() {
        String dottedLine = String.join("", Collections.nCopies(position, "-"));
        return String.format("%s:%s", this.name, dottedLine);
    }
}
