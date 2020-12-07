package racingcar;

import utils.RandomUtils;

public class Car {
    private static final int RANDOM_MIN_NUMBER = 0;
    private static final int RANDOM_MAX_NUMBER = 9;
    private static final int MOVE_FORWARD_POINT = 4;
    private final String name;

    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveOrStop() {
        int progressCheck = RandomUtils.nextInt(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);
        if (progressCheck >= MOVE_FORWARD_POINT) {
            moveForward();
        }
    }

    private void moveForward() {
        position++;
    }
}
