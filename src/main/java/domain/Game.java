/*
 * 클래스 이름: Game
 * 버전 정보: v1.0
 * 날짜: 12월 7일
 * 저작권 주의
 */

package domain;

import java.util.Scanner;
import java.util.Random;

public class Game {
    private Car[] cars;
    private int race;

    public void runGame() {
        this.gameSetting();
        this.gameRun();
        this.gameResult();
    }

    /* 게임을 세팅해주는 부분 */
    public void gameSetting() {
        Scanner sc = new Scanner(System.in);
        this.setNames(sc);
        this.setRaceNumber(sc);
        System.out.println();
    }

    public void setNames(Scanner sc) {
        String[] carNames = {};
        while (true) {
            System.out.println("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNamesInput = sc.nextLine();
            carNames = carNamesInput.split(",");
            if (isNameLimitSatisfied(carNames) == true) break;
            System.out.println("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
        }
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        this.cars = cars;
    }

    public boolean isNameLimitSatisfied(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() >= 6 || carNames[i].length() == 0) {
                return false;
            }
        }
        return true;
    }

    public void setRaceNumber(Scanner sc) {
        int race = 0;
        while (true) {
            System.out.println("시도할 회수는 몇회인가요?");
            race = sc.nextInt();
            if (race != 0) break;
            System.out.println("시도할 회수는 1회 이상만 가능합니다.");
        }
        this.race = race;
    }


    /* 게임을 실행하는 부분 */
    public void gameRun() {
        System.out.println("실행 결과");
        for (int i = 0; i < race; i++) {
            this.eachRace();
            System.out.println();
        }
    }

    public void eachRace() {
        Random random = new Random();
        for (int i = 0; i < cars.length; i++) {
            if (random.nextInt(10) >= 4) cars[i].moveForward();
            System.out.println(cars[i].getName() + " : " + cars[i].currentPosition());
        }
    }


    /* 게임 결과를 출력해주는 부분 */
    public void gameResult() {
        System.out.println(fastestCar(cars) + "가 최종 우승했습니다.");
    }

    public String fastestCar(Car[] cars) {
        String fastestCar = "";
        int maxPosition = -1;
        for (int i = 0; i < cars.length; i++) {
            if (maxPosition < cars[i].getPosition()) {
                maxPosition = cars[i].getPosition();
                fastestCar = "";
                fastestCar += cars[i].getName();
                continue;
            }
            if (maxPosition == cars[i].getPosition()) {
                fastestCar += ", " + cars[i].getName();
            }
        }
        return fastestCar;
    }


}
