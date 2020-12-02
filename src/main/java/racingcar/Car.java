package racingcar;

import utils.RandomUtils;

public class Car {

    private static final String COLON = " : ";
    private static final String POSITION_DASH = "-";
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void run() {
        if (generateRandomNumber()) {
            position++;
        }
        System.out.println(getName() + COLON + getPosition());
    }

    public int getPositionNumber() {
        return position;
    }

    public String getPosition() {
        String carPosition = null;
        for (int i = 0; i < position; i++) {
            carPosition += POSITION_DASH;
        }
        return carPosition;
    }

    private boolean generateRandomNumber() {
        return RandomUtils.nextInt(0, 9) >= 4;
    }
}
