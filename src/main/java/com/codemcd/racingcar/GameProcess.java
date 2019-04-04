/*
 * @(#)GameProcess.java
 * v2.0
 * 2019/04/03
 */

package com.codemcd.racingcar;

import java.util.Random;

/**
 * 게임에 필요한 기능을 수행하는 클래스
 *
 * @author 박성범
 * @version v2.0
 */
public class GameProcess {

    private static final int MAX_NUMBER_SIZE = 10;

    public static int makeRandomNumber() {

        Random random = new Random();
        int randomNumber = random.nextInt(MAX_NUMBER_SIZE);
        return randomNumber;
    }

    private static int getMaxPosition(Car[] cars) {

        int maxPosition = 0;
        for (int i = 0; i < cars.length; ++i) {
            if (maxPosition < cars[i].getPosition()) {
                maxPosition = cars[i].getPosition();
            }
        }
        return maxPosition;
    }

    private static int getNumberOfWinner(Car[] cars, int maxPosition) {

        int numberOfWinner = 0;
        for (int i = 0; i < cars.length; ++i) {
            if (cars[i].getPosition() == maxPosition) {
                numberOfWinner++;
            }
        }
        return numberOfWinner;
    }

    public static String[] tellWinner(Car[] cars) {

        int maxPosition = getMaxPosition(cars);
        int numberOfWinner = getNumberOfWinner(cars, maxPosition);
        String[] winners = new String[numberOfWinner];
        int winnerIndex = 0;
        for (int i = 0; i < cars.length; ++i) {
            if (cars[i].getPosition() == maxPosition) {
                winners[winnerIndex++] = cars[i].getName();
            }
        }
        return winners;
    }
}
