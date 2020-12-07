package racingcar;

import utils.RandomUtils;

public class Car implements Comparable<Car>{
    private static final int MIN = 0;
    private static final int MAX = 9;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int makeRandomNumber() {
        return RandomUtils.nextInt(MIN, MAX);
    }

    public void move() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car o) {
        return o.getPosition() - getPosition();
    }
}
