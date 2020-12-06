package racingcar;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position = 0;

    private final int START_INCLUSIVE = 1;
    private final int END_INCLUSIVE = 9;
    private final int FORWARD_CRITERION = 4;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void startTurn() {
        if (RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE) >= FORWARD_CRITERION) {
            goForward();
        }
    }

    private void goForward() {
        this.position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
