package racingcar;

import utils.RandomUtils;

public class Car {
    private static final int MIN = 0;
    private static final int MAX = 9;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    private int makeRandomNumber() {
        return RandomUtils.nextInt(MIN, MAX);
    }

    // 추가 기능 구현
}
