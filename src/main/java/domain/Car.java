/**
 * 클래스 이름       Car
 * 버전 정보        1.0
 * 날짜            2019.12.10
 * 저작권          joi0104
 */

package domain;

import java.util.Random;

public class Car {
    private static final int MIN_MOVE_FORWARD_NUM = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void moveForward() {
        int randomNumber = generateRandomNumber();
        if (randomNumber < MIN_MOVE_FORWARD_NUM) {
            position++;
        }
    }

    public void printPosition() {
        System.out.print(name + ":");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt();
    }
}
