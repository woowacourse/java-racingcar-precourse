package racingcar;

import utils.ConstantUtils;
import utils.RandomUtils;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveOrNot() {
        int computerNumber = RandomUtils
            .nextInt(ConstantUtils.MIN_RANDOM_ZERO, ConstantUtils.MAX_RANDOM_NINE);
        if (computerNumber > ConstantUtils.MAX_NO_MOVE) {
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
