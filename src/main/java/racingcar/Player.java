package racingcar;

import utils.RandomUtils;

public class Player {
    private Car car;
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int CRITERIA = 4;

    public Player(String carName) {
        car = new Car(carName);
    }

    public void racing() {
        if (driveable()) {
            car.drive();
        }
    }

    private int getRandNum() {
        return RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
    }

    private boolean driveable() {
        if (getRandNum() >= CRITERIA) {
            return true;
        }
        return false;
    }
    
}
