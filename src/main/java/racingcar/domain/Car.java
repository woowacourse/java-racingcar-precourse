package racingcar.domain;

import racingcar.constant.Condition;

public class Car implements Comparable<Car> {
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

    public void forward(int randomNumber) {
        if (randomNumber >= Condition.MINIMUM_NUMBER_FOR_FORWARD) {
            position ++;
        }
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(position, car.position);
    }
}