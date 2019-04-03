/*
 * @(#)Car.java
 * 2019년 4월 3일
 * version: 1.0.0
 * by KIM JUNG MIN
 * testprogramms9104@gmail.com
 */
package domain;

/**
 * CarGameLauncher.java는 게임로직을 시간의 흐름대로 prepareGame(), playGame(), endGame()을 통해서 실행합니다.
 *
 * @version 1.0.0
 * @author KIM JUNG MIN
 */

public class CarGameLauncher {
    public static void main(String[] args) {
        doGame();
    }

    public static void doGame() {
        Car[] cars = prepareGame();
        playGame(cars);
        endGame(cars);
    }

    public static Car[] prepareGame() {
        String[] carNames = Car.askCarNames();
        Car[] cars = Car.instantiateAndReturnCars(carNames);
        return cars;
    }

    public static void playGame(Car[] cars) {
        int totalTurns = Car.askHowManyTurns();
        int currentTurn = 0;
        System.out.println();
        System.out.println("실행결과:");
        while (currentTurn < totalTurns) {
            Car.updateCarMovements(cars);
            Car.printCarMovements(cars);
            System.out.println();
            currentTurn++;
        }
    }

    public static void endGame(Car[] cars) {
        Car.announceWinners(cars);
        System.out.println();
        boolean wantOneMoreGame = Car.getUserAnswer();
        if (wantOneMoreGame) {
            doGame();
        }
    }
}
