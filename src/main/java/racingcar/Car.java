package racingcar;

import utils.RandomUtils;

public class Car {
    public static final int MIN_RANGE = 0;
    public static final int MAX_RANGE = 9;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int randomNumber = RandomUtils.nextInt(MIN_RANGE, MAX_RANGE);
        if (randomNumber > 4) {
            position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    // 추가 기능 구현
}
