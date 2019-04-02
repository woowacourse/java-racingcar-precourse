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
    private static final int GO = 4;
    private static final int RANDOM_CONDITION = 9;

    public Car(String name) {
        this.name = name;
    }

    public void updatePosition() {
        int randomNumber = getRandomNumber();
        if(randomNumber >= GO) {
            position++;
        }
    }

    public void printPosition() {
        System.out.print(name + " : ");
        for(int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private int getRandomNumber() {
        Random ran = new Random();
        return ran.nextInt(RANDOM_CONDITION);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
