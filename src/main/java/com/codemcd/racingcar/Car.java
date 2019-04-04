/*
 * @(#)Car.java
 * v2.0
 * 2019/04/03
 */

package com.codemcd.racingcar;

/**
 * 레이싱에 참여하는 자동차의 정보 및 동작을 가지는 클래스
 *
 * @author 박성범
 * @version v2.0
 */
public class Car {

    private static final int MIN_MOVE_NUMBER = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void goStraight(int moveNumber) {
        if (moveNumber >= MIN_MOVE_NUMBER)
            this.position++;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
