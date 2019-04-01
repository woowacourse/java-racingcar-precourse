package utils;

import java.util.Random;

public interface RandomUtils {
    Random random = new Random();

    public static int getRandomNumber(int start, int end) {
        int rangeCount = end  - start + 1;
        return start + random.nextInt(rangeCount);
    }
}
