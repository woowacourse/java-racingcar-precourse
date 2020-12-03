package racingcar;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    private int getRandomValue() {
        return RandomUtils.nextInt(Constant.MIN_RANDOM_VALUE, Constant.MAX_RANDOM_VALUE);
    }

    private void forward(int value) {
        if (value >= Constant.FORWARD_CONDITION) {
            this.position++;
        }
    }
}
