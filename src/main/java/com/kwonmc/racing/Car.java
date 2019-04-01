/*
 * @(#)Car.java
 *
 * v 0.0.0
 *
 * 2019.04.01
 *
 * Copyright (c) 2019 KwonMC.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */
package com.kwonmc.racing;

/**
 * 차동차 게임에 참여하는 각 자동차들에 대한 정보를 가지고 있는 클래스
 *
 * @version 0.0.0
 * @author kwonmc
 */
public class Car implements Comparable<Car> {
    private static final int CRITERIA_OF_FORWARD_STOP = 4;
    private static final int INT_TEN = 10;

    private static final char CHAR_HYPHEN = '-';

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void goForward() {
        this.position++;
    }

    public void stop() {
        // Do Nothing
    }

    public int getPosition() {
        return position;
    }

    public String getStringPosition() {
        char[] pos = new char[this.position];
        for (int i = 0; i < pos.length; i++) {
            pos[i] = CHAR_HYPHEN;
        }
        return String.copyValueOf(pos);
    }

    private int getRandomNumber() {
        return (int) (Math.random() * INT_TEN);
    }

    public void moveByRandomNumber() {
        int rand = getRandomNumber();

        if (rand >= CRITERIA_OF_FORWARD_STOP) {
            // 4 이상일 때 전진
            goForward();
        }

        if (rand < CRITERIA_OF_FORWARD_STOP) {
            // 3 이하일 때 멈춤
            stop();
        }
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.position, o.position);
    }
}
