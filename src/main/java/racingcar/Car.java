package racingcar;

import utils.RandomUtils;

public class Car {
    private static final int DEFAULT_MAX_RANDOM_NUM = 9;
    private static final int DEFAULT_MIN_RANDOM_NUM = 0;
    private static final int DEFAULT_MOVE_NUM = 3;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void increasePosition() {
        if (RandomUtils.nextInt(DEFAULT_MIN_RANDOM_NUM, DEFAULT_MAX_RANDOM_NUM) > DEFAULT_MOVE_NUM) {
            position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getCarName() {
        return this.name;
    }
}
