package racingcar;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position = 0;
    private final int RANDOM_UPPER_BOUND = 9;
    private final int RANDOM_LOWER_BOUND = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public int getPosition() {
        return position;
    }
    public String getName() { return name; }
    public void moveForward() {
        if(RandomUtils.nextInt(RANDOM_LOWER_BOUND, RANDOM_UPPER_BOUND) >= 4) {
            position++;
            return;
        }
        return;
    }

}
