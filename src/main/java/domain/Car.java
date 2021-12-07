package domain;

import service.RandomNumberGenerator;

public class Car {
    private final int FORWARD_BOUND = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현


    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void move() {
        position++;
    }

    public void moveOrStop(int number) {
        if (number >= FORWARD_BOUND) {
            move();
        }
    }
}
