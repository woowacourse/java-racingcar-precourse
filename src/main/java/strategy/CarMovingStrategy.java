package strategy;

import util.RandomNumberGenerator;

public class CarMovingStrategy implements MovingStrategy {
    private static final int BOUND_MIN = 0;
    private static final int BOUND_MAX = 9;
    private static final int MOVING_CRITERIA = 4;
    private RandomNumberGenerator generator = new RandomNumberGenerator(BOUND_MIN, BOUND_MAX);

    @Override
    public boolean isMovable() {
        return (generator.getNumber() >= MOVING_CRITERIA);
    }
}