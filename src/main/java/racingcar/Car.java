package racingcar;

import utils.RandomUtils;

public class Car implements Comparable<Car> {
    public static final int MINIMUM = 0;
    public static final int MAXIMUM = 9;
    public static final int CRITERION = 4;
    public static final String UNIT_SYMBOL = "-";

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void moveRandomly() {
        int randomNumber = RandomUtils.nextInt(MINIMUM, MAXIMUM);

        if (randomNumber >= CRITERION) {
            this.position += 1;
        }

        return;
    }

    @Override
    public String toString() {
        return this.name + " : " + UNIT_SYMBOL.repeat(this.position);
    }

    @Override
    public int compareTo(Car car) {
        return this.position - car.position;
    }
}
