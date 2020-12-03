package racingcar;

import ui.Output;
import utils.RandomUtils;

import java.util.Scanner;

public class Car {

    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public void move() {
        int movingDistance = getRandomNumber();
        if (movingDistance >= 4) {
            position += 1;
        }
        Output.printResult(name, position);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private void validateNameLength(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("[Error] 경주할 자동차 이름이 6자 이상이면 안 됩니다.");
        }
    }

    private int getRandomNumber() {
        return RandomUtils.nextInt(START_NUMBER, END_NUMBER);
    }
}
