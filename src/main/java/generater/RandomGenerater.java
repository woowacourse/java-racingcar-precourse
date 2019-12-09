package generater;

import java.util.Random;

public class RandomGenerater {
    private static final int UPPER_BOUND = 10;

    public int generateRandom() {
        return new Random().nextInt(UPPER_BOUND);
    }
}
