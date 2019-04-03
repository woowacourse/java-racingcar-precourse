package domain;

import utils.RandomUtils;

class Car {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position = 0;

    private Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if(name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("유효하지 않은 이름 길이" + "name : " + name);
        }
    }

    static Car fromName(String name) {
        return new Car(name);
    }

    String getName() {
        return name;
    }

    int getPosition() {
        return position;
    }

    void move() {
        position++;
    }

    boolean isMovable() {
        return RandomUtils.getRandomNumberBetween(1, 9) >= 4;
    }
}
