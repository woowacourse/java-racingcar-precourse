package racingcar.domain;

import utils.RandomUtils;

import java.util.Collections;

public class Car {
    private final int START_INCLUSIVE = 1;
    private final int END_INCLUSIVE = 9;
    private final int FORWARD_CRITERION = 4;
    private final String BAR = "-";

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

    public void printResult() {
        System.out.printf("%s : %s\n", this.name, convertPositionToBar());
    }

    private String convertPositionToBar() {
        return String.join("", Collections.nCopies(position, BAR));
    }

    public int getPosition() {
        return this.position;
    }
}
