package racingcar;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getPositon() {
        return position;
    }

    public void setPosition() {
        position++;
    }

    public String getName() {
        return name;
    }

    public boolean moveForward() {
        int conditionNumber = RandomUtils.nextInt(0, 9);
        return conditionNumber > 3;
    }
}
