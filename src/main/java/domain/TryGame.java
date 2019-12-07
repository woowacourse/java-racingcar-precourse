/*
 * class: TryGame
 *
 * version: 1.0
 *
 * date: 2019.12.07
 *
 * 이 프로그램의 저작권은 정은석에게 있습니다.
 * Copyright 2019.12.07
 */

package domain;

/**
 * 게임을 구성해서 실행해주는 class.
 *
 * @author joseph415
 * @version 1.0 2019.12.07
 */
public class TryGame {

    /**
     * 게임을 구성해서 실행해주는 start매소드.
     * 각 클래스의 객체를 생성해서 게임을 구성.
     */
    public void start() {
        int tryCount;
        Car[] car;
        MakeCar makeCar = new MakeCar();
        TryInput tryInput = new TryInput();
        WinsCar winsCar = new WinsCar();

        /*car의 이름을입력받아 동적으로 car배열 만듬*/
        car = makeCar.makingCar();

        /*시도횟수를 입력받는 매소드*/
        tryCount = tryInput.tryInput();

        /*게임을 시도횟수만큼 실행해서 우숭자의 이름을 출력하는 반복문*/
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
