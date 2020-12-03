package racingcar;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position = 0;
    static final int START_BOUND = 0;
    static final int END_BOUND = 9;
    static final int BOUNDARY_VALUE = 4;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public String getName() {
        return name;
    }

    public void tryMove() {
        if (RandomUtils.nextInt(START_BOUND, END_BOUND) >= BOUNDARY_VALUE) {
            position++;
        }
    }

}
