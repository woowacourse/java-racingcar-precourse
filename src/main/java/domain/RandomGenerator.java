package domain;

import java.util.Random;

public class RandomGenerator {
    static final int MIN_RANGE = 0;
    static final int MAX_RANGE = 9;

    private int randomNumber;

    private RandomGenerator() {}

    private static class InnerInstanceClass {
        private static final RandomGenerator instance = new RandomGenerator();
    }

    public static RandomGenerator getInstance() {
        return InnerInstanceClass.instance;
    }

    public int getRandomNumber() {
        run();
        return randomNumber;
    }

    private void run() {
        randomNumber = new Random().nextInt(MAX_RANGE) + MIN_RANGE;
    }

}
