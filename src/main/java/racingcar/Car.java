package racingcar;

import utils.RandomUtils;

public class Car implements Comparable<Car> {
    public static final int MIN_RANGE = 0;
    public static final int MAX_RANGE = 9;
    public static final int PIVOT_FOR_MOVE = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int randomNumber = RandomUtils.nextInt(MIN_RANGE, MAX_RANGE);
        if (randomNumber >= PIVOT_FOR_MOVE) {
            position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Car o) {
        // TODO Auto-generated method stub
        return o.position - this.position;
    }

}
