/*
 * @(#)Car.java          2019/04/04
 *
 * Copyright (c) 2019 Seungwoo Lee.
 * All rights reserved.
 *
 */

package domain;

import java.util.Random;

/**
 * Racing Game을 하기 위한 Car 객체로서
 * Game을 하기 위해 필요한 필드 및 메소드가 정의된 클래스입니다.
 *
 * @author 이승우
 * @version 1.00 2019년 4월 4일
 */
public class Car {
    private final String name;
    private int position = 0;
    private final int boundary = 10;            // 랜덤으로 생성하는 숫자의 한계
    private final int judge = 4;            // 전진할지 말지 결정하는 숫자

    public Car(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {             // Car가 전진할지 말지 결정
        Random rand = new Random();
        int standard = rand.nextInt(boundary);
        System.out.println(standard);

        if (standard >= judge) {
            position++;
        }
    }

    public void showMoveProgress() {              // 전진 결과를 '-'의 개수로 나타냄
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < position; i++) {
            result.append("-");
        }
        System.out.println(name + ": " + result);
    }
}
