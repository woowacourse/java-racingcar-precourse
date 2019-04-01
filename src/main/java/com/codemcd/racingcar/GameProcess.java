package com.codemcd.racingcar;

import java.util.Random;

public class GameProcess {

    private static int MAX_NUMBER_SIZE = 10;

    public int makeRandomNumber() {

        Random random = new Random();

        return random.nextInt(MAX_NUMBER_SIZE);
    }

    private int getMaxPosition(Car[] cars, int carsArraySize) {

        int maxPosition = 0;

        for (int i = 0; i < carsArraySize; ++i) {
            if (maxPosition < cars[i].getPosition()) {
                maxPosition = cars[i].getPosition();
            }
        }

        return maxPosition;
    }

    private int getNumberOfWinner(Car[] cars, int carsArraySize, int maxPosition) {

        int numberOfWinner = 0;

        for (int i = 0; i < carsArraySize; ++i) {
            if (cars[i].getPosition() == maxPosition) {
                numberOfWinner++;
            }
        }

        return numberOfWinner;
    }

    public String[] tellWinner(Car[] cars, int carsArraySize) {

        String[] winners;
        int maxPosition = getMaxPosition(cars, carsArraySize);
        int numberOfWinner = getNumberOfWinner(cars, carsArraySize, maxPosition);
        winners = new String[numberOfWinner];
        int wIndex = 0;

        for (int i = 0; i < carsArraySize; ++i) {
            if (cars[i].getPosition() == maxPosition) {
                winners[wIndex++] = cars[i].getName();
            }
        }

        return winners;
    }
}
