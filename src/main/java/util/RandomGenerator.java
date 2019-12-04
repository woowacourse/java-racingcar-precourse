package util;

import java.util.Random;

public class RandomGenerator {
    private Random random;
    private final int FORWARD_NUMBER = 4;
    private final int BOUND_NUMBER = 10;

    public RandomGenerator() {
        this.random = new Random();
    }

    public boolean isGoingForward() {
        int number = this.random.nextInt(BOUND_NUMBER);
        System.out.println("Random number: " + number);
        if (number >= FORWARD_NUMBER) {
            return true;
        }
        return false;
    }
}
