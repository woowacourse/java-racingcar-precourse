package domain.car.engine;

import java.util.Random;

public class RandomEngine implements Engine {
    private static final int BOUND = 10;

    @Override
    public int getPower() {
        return new Random().nextInt(BOUND);
    }
}
