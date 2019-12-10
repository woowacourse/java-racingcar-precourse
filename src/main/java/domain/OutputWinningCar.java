/*
 * class: OutputWinningCar
 *
 * version: 4.0
 *
 * date: 2019.12.10
 *
 * 이 프로그램의 저작권은 정은석에게 있습니다.
 * Copyright 2019.12.10
 */

package domain;

/**
 * 우승차를 출력해주는 기능
 */
public class OutputWinningCar {

    /**
     * 우승자를 출력하는 매소드이다
     *
     * @param tryCount 사용자가 입력한 시도횟수
     * @param car      car객체를 담고있는 배열
     */
    public void printWinsCar(int tryCount, Car[] car) {
        WinningCar winningCar = new WinningCar();

        for (int i = 0; i < tryCount; i++) {
            for (int j = 0; j < car.length; j++) {
                car[j].forwordPosition();
                System.out.println(String.format("%-5s", car[j].getName()) + ":" +
                        new String(new char[car[j].getPosition()]).replace("\0", "-"));
            }
            System.out.println();
        }
        System.out.println(winningCar.wins(car) + "가 최종우승 하였습니다.");
    }
}
