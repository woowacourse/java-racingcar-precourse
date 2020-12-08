package racingcar;

import utils.RandomUtils;

public class Car {
    public static final int MINIMUM = 0;
    public static final int MAXIMUM = 9;
    public static final int CRITERION = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveRandomly() {
        int randomNumber = RandomUtils.nextInt(MINIMUM, MAXIMUM);

        if (randomNumber > CRITERION) {
            this.position += 1;
        }

        return;
    }
}
