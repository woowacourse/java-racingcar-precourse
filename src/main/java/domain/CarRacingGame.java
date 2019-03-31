/*
 * @CarRacingGame.java      0.1 2019/03/31
 */

package domain;

import java.util.Scanner;

/**
 * 자동차 경주게임을 진행하는 클래스
 *
 * @author 이도원
 * @version 0.1 2019/03/31
 */
public class CarRacingGame {
    private String[] carNames;
    private Car[] cars;

    public CarRacingGame() {
    }

    public void turnOn() {
        start();
    }

    private void start() {
        inputCarName();
        readyCar();
    }

    private void inputCarName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameString = sc.nextLine();

        carNames = carNameString.split(",");
    }

    /* Car 객체를 생성하는 메소드 */
    private void readyCar() {
        int size = carNames.length;
        cars = new Car[size];

        for (int i = 0; i < size; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }
}
