package racingcar;

import utils.RandomUtils;

public class Car {
    private static final int MIN = 0;
    private static final int MAX = 9;
    private static final int FORWARD_CONDITION = 4;

    private final String name;
    private int position = 0;
    private int randomNumber = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setRandomNumber() {
        this.randomNumber = RandomUtils.nextInt(MIN, MAX);
    }

    public void action() {
        setRandomNumber();

        if (randomNumber >= FORWARD_CONDITION) {
            position++;
        }
    }
}
