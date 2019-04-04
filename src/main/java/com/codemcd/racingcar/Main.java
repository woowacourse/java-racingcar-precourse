/*
 * @(#)Main.java
 * v2.0
 * 2019/04/03
 */

package com.codemcd.racingcar;

/**
 * 레이싱 게임을 진행하는 클래스
 *
 * @author 박성범
 * @version v2.0
 */
public class Main {

    public static void main(String[] args) {

        String[] carName = Input.inputCarName();
        int numberOfMove = Input.inputHowManyMove();
        int numberOfCar = carName.length;
        Car[] cars = new Car[numberOfCar];
        for (int i = 0; i < numberOfCar; ++i) {
            cars[i] = new Car(carName[i]);
        }

        startRacing(cars, numberOfMove);
        endGameAndOutputWinner(cars);
    }

    private static void startRacing(Car[] cars, int numberOfMove) {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < numberOfMove; ++i) {
            for (int j = 0; j < cars.length; ++j) {
                int moveNumber = GameProcess.makeRandomNumber();
                cars[j].goStraight(moveNumber);
            }
            Output.outputMoveResult(cars);
        }
    }

    private static void endGameAndOutputWinner(Car[] cars) {
        String[] winners = GameProcess.tellWinner(cars);
        Output.outputWhoIsWinners(winners);
    }
}
