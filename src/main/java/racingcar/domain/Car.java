package racingcar.domain;

import utils.RandomUtils;

public class Car implements Comparable<Car> {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int FORWARD_CRITERION = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void startTurn() {
        if (isGoForward()) {
            goForward();
        }
    }

    private boolean isGoForward() {
        return RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE) >= FORWARD_CRITERION;
    }

    private void goForward() {
        this.position++;
    }

    @Override
    public int compareTo(Car car) {
        return this.position - car.getPosition();
    }

    public boolean isSamePosition(Car car) {
        return this.position == car.position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
