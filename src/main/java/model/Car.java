package model;

import strategy.CarMovingStrategy;
import strategy.MovingStrategy;
import util.StringUtil;

public class Car {
    private static final int MOVING_DISTANCE = 1;
    private MovingStrategy movingStrategy = new CarMovingStrategy();
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void tryMoving() {
        if (movingStrategy.isMovable()) {
            position += MOVING_DISTANCE;
        }
    }

    @Override
    public String toString() {
        return name + " : " + StringUtil.getPositionSymbol(position);
    }
}
