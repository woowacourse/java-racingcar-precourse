package racingcar.domain;

import racingcar.domain.engine.Engine;

public class Car {

    private static final int MOVE_NUM = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void move(Engine engine) {
        if (engine.getDigit() >= MOVE_NUM) {
            this.position += 1;
        }
    }

    @Override
    public String toString() {
        return this.name + " : " + displayCurrentPosition();
    }

    private String displayCurrentPosition() {
        StringBuilder currentPosition = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            currentPosition.append("-");
        }
        return currentPosition.toString();
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
