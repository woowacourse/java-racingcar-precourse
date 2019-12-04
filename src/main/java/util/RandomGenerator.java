package util;

import java.util.Random;

public class RandomGenerator {
    private static final int FORWARD_NUMBER = 4;
    private static final int BOUND_NUMBER = 10;
    private Random random;

    public RandomGenerator() {
        this.random = new Random();
    }

    public boolean isGoingForward() {
        int number = random.nextInt(BOUND_NUMBER);
        return number >= FORWARD_NUMBER;
    }
}
