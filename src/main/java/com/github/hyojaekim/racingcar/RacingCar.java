package com.github.hyojaekim.racingcar;

import java.util.Scanner;

public class RacingCar {

    private void gameStart(Scanner sc) {
        String carsName = getCarsName(sc);                      //전체 자동차 입력받기
        RacingCarGame rcg = new RacingCarGame(carsName);        //각각의 자동차 등록
        int maxCount = getMaxTryCount(sc);                      //시도할 횟수 입력받기

        System.out.println("\n실행 결과");
        for (int i = 0; i < maxCount; i++) {
            rcg.startRacingGame();
        }
        rcg.setMaxPosition();
        rcg.printVictoryCar();
    }

    private String getCarsName(Scanner sc) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return sc.nextLine();
    }

    private int getMaxTryCount(Scanner sc) {
        System.out.println("시도할 회수는 몇회인가요?");
        int cnt = sc.nextInt();

        if (cnt < 0) {
            System.out.println("0보다 작은 수를 입력하셨습니다.");
            System.exit(0);
        }
        return cnt;
    }

    public static void main(String[] args) {
        RacingCar rc = new RacingCar();
        Scanner sc = new Scanner(System.in);
        rc.gameStart(sc);
    }
}