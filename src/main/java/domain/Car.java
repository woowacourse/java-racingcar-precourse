/*
 * @(#)Main.java        0.1 2019/04/01
 *
 *
 */

package domain;

import java.util.Random;

/**
 * Car 객체 생성을 위한 클래스입니다.
 *
 * @author 반선호
 * @version 0.1 2019년 4월 01일
 */

public class Car {
    private static final int MAXIMUM_RANDOM_VALUE = 10;
    private static final int MOVE_DECISION_VALUE = 4;

    private final String name;
    private int position = 0;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public void runOneCycle() {
        createRandomDistance();
        if (isLagerThanFour()) {
            movePosition();
        }
        printCurrentPosition();
    }

    private void createRandomDistance() {
        Random random = new Random();
        distance = random.nextInt(MAXIMUM_RANDOM_VALUE);
    }

    private boolean isLagerThanFour() {
        return (distance >= MOVE_DECISION_VALUE);
    }

    private void movePosition() {
        position++;
    }

    private void printCurrentPosition() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
