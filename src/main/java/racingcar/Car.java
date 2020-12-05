package racingcar;

import utils.RandomUtils;

public class Car {
    private static int MINIMUM_RPM = 0;
    private static int MAXIMUM_RPM = 9;
    private static int MOVABLE_MINIMUM_RPM = 4;
    private static int SPEED = 1;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public boolean isMovable() {
        int currentRpm = RandomUtils.nextInt(MINIMUM_RPM, MAXIMUM_RPM);
        if (currentRpm < MOVABLE_MINIMUM_RPM) {
            return false;
        }
        return true;
    }

    public void move() {
        this.position += SPEED;
    }

    public String getCarName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
