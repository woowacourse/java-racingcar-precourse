/*
 * @(#)RacingGame.java          2019/04/04
 *
 * Copyright (c) 2019 Seungwoo Lee.
 * All rights reserved.
 *
 */

package game;

import domain.Car;

import java.util.Scanner;

/**
 * Car 객체를 활용하여 입력받은 이름만큼의 Car들이 입력받은 횟수만큼
 * Racing Game을 하면서 중간 결과를 출력하고 최종 우승자를 알려주는 클래스입니다.
 *
 * @author 이승우
 * @version 1.00 2019년 4월 4일
 */
public class RacingGame {
    private static Car[] cars;               // 게임에 참가할 Car들을 담을 배열
    public static Announcer announcer;
    private static final int nameMaxLength = 5;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {                // Racing Game 실행
        int trying;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        while (makeRacingCars() == false) ;
        System.out.println("시도할 회수는 몇회인가요?");
        trying = input.nextInt();
        System.out.println();

        System.out.println("실행결과");
        for (int i = 0; i < trying; i++) {
            race();
            announcer.showRaceProgress(cars);
        }

        announcer.tellWinner(cars);
    }

    /*
     * 입력받은 자동차 이름들의 공백을 없애고 이를 통해 Car들을 생성한다
     * 만약 자동차 이름 길이가 5자 초과면 전체 입력을 다시 받는다
     */
    public static boolean makeRacingCars() {
        String carNameSet = input.nextLine();
        String[] carNames = carNameSet.split(",");
        cars = new Car[carNames.length];

        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].trim().length() > nameMaxLength) {
                System.out.println("오류: 5자 초과인 이름이 존재합니다. 입력을 다시 해주세요.");
                return false;
            }
            cars[i] = new Car(carNames[i].trim());
        }

        return true;
    }

    public static void race() {
        for (int i = 0; i < cars.length; i++) {
            cars[i].move();
        }
    }
}

