/*
 * 이 클래스는 자동차 경주 게임에서 사용되는 자동차에 대한 클래스입니다
 *
 *
 * 클래스 이름    Car
 *
 * 버전 정보     1.0
 *
 * 날짜    2019/04/02
 *
 * 저작권   권유상
 */

package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;
    private static final int GO = 4;    //random number에 대해 자동차가 전진할 수 있는 조건
    private static final int MAX_RANDOM_NUMBER = 10;     //random number 생성 범위

    public Car(String name) {
        this.name = name;
    }

    public void updatePosition() {
        int randomNumber = getRandomNumber();
        if (randomNumber >= GO) {
            position++;
        }
    }

    public void printPosition() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private int getRandomNumber() {
        Random ran = new Random();
        return ran.nextInt(MAX_RANDOM_NUMBER);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
