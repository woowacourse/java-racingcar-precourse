/*
 * class: PrintWinsCar
 *
 * version: 3.0
 *
 * date: 2019.12.08
 *
 * 이 프로그램의 저작권은 정은석에게 있습니다.
 * Copyright 2019.12.08
 */

package domain;

/**
 * 우승차를 출력해주는 기능
 */
public class PrintWinsCar {

    /**
     * 우승자를 출력하는 매소드이다
     * @param tryCount 사용자가 입력한 시도횟수
     * @param car car객체를 담고있는 배열
     */
    public void printWinsCar(int tryCount, Car[] car) {
        WinsCar winsCar = new WinsCar();

        for (int i = 0; i < tryCount; i++) {
            for (int j = 0; j < car.length; j++) {
                car[j].forwordPosition();
                System.out.print(car[j].getName() + ":" + car[j].getPosition());
                System.out.println();
            }
            System.out.println();
        }
        System.out.println(winsCar.wins(car) + "가 최종우승 하였습니다.");
    }
}
