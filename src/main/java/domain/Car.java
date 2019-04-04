/*
 * @Car.java     0.1 2019-04-04
 * Copyright(c) 2019 LeeYunSeop All rights reserved.
 * */

package domain;

import java.util.Random;

/**
 * Racing-Car game의 Car object
 * move method로 Car의 위치가 결정됨
 *
 * @author yun
 * @version 0.1
 */
public class Car {
    private final String name;
    private int position = 0;
    private static final int THRESHOLD = 4; // 기준값

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    } // 이름 반환

    public int getPosition() {
        return this.position;
    } // 위치 반환

    /**
     * position을 증가시키는 method
     * 0 ~ 9의 임의의 수를 생성하고 THRESHOLD보다 크면 position + 1
     */
    public void move() {
        Random rand = new Random();
        int randomValue = rand.nextInt(10);
        int isMoving = randomValue > THRESHOLD ? 1 : 0;
        this.position += isMoving;
    }

}
