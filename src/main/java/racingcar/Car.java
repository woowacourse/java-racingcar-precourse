package racingcar;

import utils.RandomUtils;

public class Car {
    private static final int MINIMUM_DISTANCE = 0;
    private static final int MAXIMUM_DISTANCE = 9;
    private static final int MOVING_POSSIBLE_MIN_LENGTH = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    private int randomDistance() {
        return RandomUtils.nextInt(MINIMUM_DISTANCE, MAXIMUM_DISTANCE);
    }

    private boolean isReallyMoving(int distance) {
        return distance >= MOVING_POSSIBLE_MIN_LENGTH;
    }

    public void tryingMove() {
        int distance = randomDistance();
        if(isReallyMoving(distance)) {
            this.position += distance;
        }
    }
    // 추가 기능 구현
}
