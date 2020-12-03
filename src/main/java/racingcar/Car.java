package racingcar;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int move() {
        if (RandomUtils.nextInt(0, 9) > 3) {
            position++;
        }
        return position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
