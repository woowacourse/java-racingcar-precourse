/*
 * @(#)Car.java     0.6 2019.12.07
 *
 * Copyright (c) 2019 lxxjn0.
 */
package domain;

import java.util.Random;

/**
 * Car 클래스
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 0.6 2019.12.07
 */
public class Car {
    /**
     * 생성 가능한 random 변수의 최대 범위를 제한하기 위한 상수.
     */
    private static final int MAX_RANDOM_NUMBER = 9;

    /**
     * 자동차들 중에서 가장 먼 위치의 값을 저장하는 변수.
     */
    private static int maxPosition = 0;

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

    /**
     * 자동차를 앞으로 전진시키고, 전진한 위치가 모든 자동차들 중 가장 큰 값이면 해당 위치로
     * 최댓값(maxPosition)을 초기화시키는 메소드.
     */
    public void moveCarToForward() {
        if (isCarMoveForward()) {
            position++;
            if (position > maxPosition) {
                maxPosition = position;
            }
        }
    }

    /**
     * name getter
     *
     * @return 자동차의 이름을 반환.
     */
    public String getName() {
        return name;
    }

    /**
     * position getter
     *
     * @return 자동차의 현재 위치를 반환.
     */
    public int getPosition() {
        return position;
    }

    /**
     * maxPosition getter
     *
     * @return 자동차들 중에서 가장 큰 position의 값을 반환.
     */
    public static int getMaxPosition() {
        return maxPosition;
    }
}
