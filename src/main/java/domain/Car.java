/**
 * Car.java
 * 아직 리팩토링 중...
 * 우아한테크코스 프리코스 2주차.
 * Original code https://github.com/hotheadfactory/java-racingcar-precourse
 * Version: v0.0.1, 2019.12.05 (c) 정회형
 */
package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    // 이 위로 건드리면 안됨!

    public void playTurn() {
        Random random = new Random();
        if (random.nextInt(10) >= 4) {
            this.proceed();
        }
        System.out.println(name + " : " + getBar());
    }

    private void proceed() {
        position++;
    }

    private String getBar() {
        String bar = "";
        for (int i = 0; i < position; i++) {
            bar += "-";
        }
        return bar;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }


}
