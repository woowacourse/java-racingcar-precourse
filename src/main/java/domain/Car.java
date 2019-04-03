package domain;

import java.util.Random;

public class Car {
    private final String name;
    private final int TRAVEL_DISTANCE_BY_ONE_MOVE = 1;
    private final int RANDOM_BOUND = 10;
    private final int THRESHOLD = 4;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveForward() {
        this.position += this.TRAVEL_DISTANCE_BY_ONE_MOVE;
    }

    public void randomMove() {
        int randomPick = (new Random()).nextInt(this.RANDOM_BOUND);

        if (randomPick >= this.THRESHOLD) {
            moveForward();
        }
    }
}