package domain;

import java.util.concurrent.ThreadLocalRandom;

public class Car {
    private static final int MIN_RANDOM_RANGE = 0;
    private static final int MAX_RANDOM_RANGE = 10;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int randomGenerator() {
        return ThreadLocalRandom.current().ints(MIN_RANDOM_RANGE, MAX_RANDOM_RANGE)
                .limit(1)
                .findAny()
                .orElse(0);
    }
}
