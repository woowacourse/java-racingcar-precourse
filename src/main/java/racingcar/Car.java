package racingcar;

import utils.RandomUtils;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    public void moveForward() {
        if (isMoveForward()) {
            this.position += Constants.MOVING_POSITION_POINT;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getRacerName() {
        return this.name;
    }

    private boolean isMoveForward() {
        int randomNumber = RandomUtils.nextInt(
            Constants.MIN_RANDOM_RANGE, Constants.MAX_RANDOM_RANGE);
        if (randomNumber >= Constants.GO_FORWARD_MIN_NUMBER) {
            return true;
        }
        if (randomNumber <= Constants.KEEP_POSITION_MAX_NUMBER) {
            return false;
        }
        return false;
    }
}
