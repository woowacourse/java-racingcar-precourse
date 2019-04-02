/**
 * 이 클레스는  Car 객체에 관한 클래스 이다.
 *
 *className     Car
 *version 	    1.0.0
 *Date		    01/04/2019
 *author	    권경동
 */

package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    private void moveCheak(int num) {
        if (num >= 4) {
            this.position++;
        }
    }

    private void statusOutput() {
        System.out.print(this.name);
        System.out.print(" : ");
        for (int i = 0; i < this.position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void race() {
        moveCheak(getRandomNumber());
        statusOutput();
    }
}
