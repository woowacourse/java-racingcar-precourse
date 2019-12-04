/*
 * 클래스 이름   StartGame
 * 버전 정보    1.0
 * 날짜        2019.12.05
 * 저작권      YebinK
 */

package domain;

import java.util.Random;

public class StartGame {

    Car[] cars;

    public void start(Car[] cars) {
        this.cars = cars;

        getRandomNumber();
    }

    private void getRandomNumber() {
        Random r = new Random();

        for (int i = 0 ; i < cars.length ; i++) {
            int number = r.nextInt(9);
        }
    }
}
