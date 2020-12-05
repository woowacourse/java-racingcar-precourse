package racingcar.domain;

import racingcar.domain.engine.Engine;

public class Car {

    private static final int GO_FORWARD_NUM = 4;
    private static final String GO_FORWARD_MARKING = "-";
    private static final int GO_FORWARD_DISTANCE = 1;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void move(Engine engine) {
        if (engine.getDigit() >= GO_FORWARD_NUM) {
            this.position += GO_FORWARD_DISTANCE;
        }
    }

    @Override
    public String toString() {
        return this.name + " : " + displayCurrentPosition();
    }

    private String displayCurrentPosition() {
        StringBuilder currentPosition = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            currentPosition.append(GO_FORWARD_MARKING);
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
