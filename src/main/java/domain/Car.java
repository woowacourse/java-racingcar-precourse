/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */
package domain;

import java.util.Random;

/**
 * 클래스 이름 : Car.java
 *
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * <p>
 * 날짜 : 2019.12.5 목요일
 */
public class Car {
    /*
     * Car 클래스에서는 클래스의 멤버와 메서드들을 정의한다.
     */

    private static final int RANDOM_NUMBER_RANGE = 10;
    private static final int MOVE_DECIDING_NUMBER = 3;

    private final String name;
    private int position = 0;


    Random random = new Random();

    /**
     * 생성자 : name을 초기화한다.
     */
    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Car 인스턴스의 position을 리턴하는 메서드.
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * Car 인스턴스의 position을 한 칸 전진하는 메서드.
     */
    public void moveForward(boolean moving) {
        if (moving) {
            this.position++;
        }
    }

    /**
     * 0 ~ RANDOM_NUMBER_RANGE - 1 범위 만큼의 정수를 리턴하는 메서드.
     */
    public int getRandomInt() {
        return random.nextInt(RANDOM_NUMBER_RANGE);
    }

    /**
     * MOVE_DECIDING_NUMBER 이하의 수가 나오면 false를 리턴하고 초과의 수가 나오면 true를 리턴하는 메서드.
     */
    public boolean decideGoOrNot(int inputNumber) {
        if (inputNumber <= MOVE_DECIDING_NUMBER) {
            System.out.println("FALSE"); // 테스트용
            return false;
        }
        System.out.println("TRUE"); // 테스트용
        return true;
    }


}
