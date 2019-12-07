/*
 * @(#)Car.java     0.3 2019.12.07
 *
 * Copyright (c) 2019 lxxjn0.
 */
package domain;

import java.util.Random;

/**
 * Car 클래스
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 0.3 2019.12.07
 */
public class Car {
    /**
     * 생성 가능한 random 변수의 최대 범위를 제한하기 위한 상수.
     */
    private static final int MAX_RANDOM_NUMBER = 9;

    /**
     * 자동차의 이름을 저장하는 문자열 변수.
     */
    private final String name;

    /**
     * 자동차의 위치를 저장하는 정수 변수.
     */
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    /**
     * 0부터 9까지의 범위 내의 정수를 랜덤하게 생성해서 반환해주는 메소드.
     *
     * @return 0부터 9까지의 범위 내의 랜덤하게 생성된 정수를 반환.
     */
    private int generateRandomNumber() {
        return new Random().nextInt(MAX_RANDOM_NUMBER);
    }

    /**
     * 자동차가 앞으로 전진하는지 여부를 판단하는 메소드.
     *
     * @return 자동차가 앞으로 전진할 경우 true 반환.
     */
    private boolean isCarMoveForward() {
        return (generateRandomNumber() > 3);
    }
}
