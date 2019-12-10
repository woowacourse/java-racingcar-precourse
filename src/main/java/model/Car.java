package model;

import strategy.CarMovingStrategy;
import strategy.MovingStrategy;

public class Car {
    private static final int MOVING_DISTANCE = 1;
    private final String name;
    private int position = 0;
    private MovingStrategy movingStrategy = new CarMovingStrategy();

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void tryMoving() {
        if (movingStrategy.isMovable()) {
            position += MOVING_DISTANCE;
        }
    }
}
