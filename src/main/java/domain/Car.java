/**
 * Car.java
 * 자동차 경주 게임
 * 우아한테크코스 프리코스 2주차.
 * Original code https://github.com/hotheadfactory/java-racingcar-precourse
 * Version: v0.0.1, 2019.12.05 (c) 정회형
 */
package domain;

import java.util.Random;

public class Car {
    private static final int RANDOM_DOMAIN = 10;
    private static final int RANDOM_LUCKYNUMBER= 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    // 이 위로 건드리면 안됨!

    public void playTurn() {
        Random random = new Random();
        if (random.nextInt(RANDOM_DOMAIN) >= RANDOM_LUCKYNUMBER) {
            this.proceed();
        }
    }

    private void proceed() {
        position++;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
