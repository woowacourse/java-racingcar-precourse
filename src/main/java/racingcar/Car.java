package racingcar;

import utils.RandomUtils;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveOrNot() {
        int computerNumber = RandomUtils
            .nextInt(Constants.MIN_RANDOM_ZERO, Constants.MAX_RANDOM_NINE);
        if (computerNumber > Constants.MAX_NO_MOVE) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
