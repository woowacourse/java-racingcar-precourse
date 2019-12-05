package domain;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Car {
    private static final int MIN_RANDOM_RANGE = 0;
    private static final int MAX_RANDOM_RANGE = 10;
    private static final int FORWARD_PIVOT = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int randomGenerator() {
        return ThreadLocalRandom.current().ints(MIN_RANDOM_RANGE, MAX_RANDOM_RANGE)
                .limit(1)
                .findAny()
                .orElse(0);
    }

    public boolean isForward(int number) {
        return number >= FORWARD_PIVOT;
    }

    public void goForward() {
        if (isForward(randomGenerator())) {
            position++;
        }
    }

    public String positionToDash(int pos) {
        if (pos == 0) {
            return "";
        }
        return positionToDash(--pos) + "-";
    }

    @Override
    public String toString() {
        return name + ":" + positionToDash(position);
    }

}
