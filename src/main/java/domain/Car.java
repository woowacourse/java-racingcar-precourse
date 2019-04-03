package domain;

import utils.RandomUtils;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position = 0;

    private Car(String name, int position) {
        validateNameLength(name);

        this.name = name;
        this.position = position;
    }

    private void validateNameLength(String name) {
        if(name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("유효하지 않은 이름 길이" + "name : " + name);
        }
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
