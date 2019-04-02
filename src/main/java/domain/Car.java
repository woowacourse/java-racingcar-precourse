package domain;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position = 0;

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car fromName(String name) {
        return new Car(name, 0);
    }

    public static Car newInstance(Car car) {
        return new Car(car.name, car.position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }

    public boolean isMovable() {
        return RandomUtils.getRandomNumber(1, 9) >= 4;
    }
}
