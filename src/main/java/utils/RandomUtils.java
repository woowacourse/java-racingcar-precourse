package utils;

import java.util.Random;

public class RandomUtils {
    private final static Random random = new Random();

    private RandomUtils(){}

    public static int getRandomNumberBetween(int start, int end) {
        int rangeCount = end  - start + 1;
        return start + random.nextInt(rangeCount);
    }
}
