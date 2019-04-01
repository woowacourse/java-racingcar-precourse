package com.molt3nrock.racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car implements Comparable {

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

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        String dottedLine = String.join("", Collections.nCopies(position, "-"));
        return String.format("%s:%s", this.name, dottedLine);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            Car other = (Car) obj;
            // position 을 기준으로 동등성 비교
            return this.position == other.position;
        }
        return false;
    }

    public int compareTo(Object obj) {
        if (obj instanceof Car) {
            Car other = (Car) obj;
            // position 을 기준으로 내림차순 정렬을 위해 큰값이 먼저 오도록 비교 Integer.compare 호출
            return Integer.compare(other.position, this.position);
        }
        return 0;
    }
}
