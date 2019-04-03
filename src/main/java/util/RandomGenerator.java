package util;

import java.util.Random;

public class RandomGenerator {
    private static final int MAX_NUM = 10;
    private static final Random random = new Random();

    public static int getRandomNumber() {
        return random.nextInt(MAX_NUM);
    }
}
