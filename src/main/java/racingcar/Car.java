package racingcar;

import utils.RandomUtils;

public class Car {
    private static final int MINIMUM_DISTANCE = 0;
    private static final int MAXIMUM_DISTANCE = 9;

    private final String name;
    private final int position = 0;

    public Car(String name) {
        this.name = name;

    }

    public int randomDistance() {
        return RandomUtils.nextInt(MINIMUM_DISTANCE, MAXIMUM_DISTANCE);
    }


    // 추가 기능 구현
}
