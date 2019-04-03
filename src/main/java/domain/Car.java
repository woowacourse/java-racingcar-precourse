package domain;

import java.util.Random;

public class Car {
    private final String name;
    private final int MOVING_STEP = 1;
    private final int RANDOM_BOUND = 10;
    private final int THRESHOLD = 4;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        position += MOVING_STEP;
    }

    public void randomMove() {
        int randomPick = (new Random()).nextInt(RANDOM_BOUND);

        if (randomPick >= THRESHOLD) {
            moveForward();
        }
    }
}