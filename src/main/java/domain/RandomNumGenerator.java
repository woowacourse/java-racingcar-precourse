package domain;

import java.util.Random;

public class RandomNumGenerator {

    private Random random;

    public RandomNumGenerator() {
        random = new Random();
    }

    public int generateRandomNum() {
        return random.nextInt(RandomNumBound.UPPER.getBound());
    }

    enum RandomNumBound {

        UPPER(10), LOWER(0);

        final int bound;

        RandomNumBound(int bound) {
            this.bound = bound;
        }

        public int getBound() {
            return bound;
        }
    }
}
