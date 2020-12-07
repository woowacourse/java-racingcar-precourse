package racingcar;

import utils.RandomUtils;

public class Car {
    private static final int MINIMUM_DISTANCE = 0;
    private static final int MAXIMUM_DISTANCE = 9;
    private static final int MIN_LENGTH_FOR_MOVING_POSSIBLE = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void tryingMove() {
        int distance = randomDistance();
        if(isPossiblyMoving(distance)) {
            this.position += distance;
        }
    }

    public int getScore() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    private int randomDistance() {
        return RandomUtils.nextInt(MINIMUM_DISTANCE, MAXIMUM_DISTANCE);
    }

    private boolean isPossiblyMoving(int distance) {
        return distance >= MIN_LENGTH_FOR_MOVING_POSSIBLE;
    }
    // 추가 기능 구현
}
