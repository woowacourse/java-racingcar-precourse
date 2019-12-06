package com.woowa.racingcar;

import java.util.Random;

public class Computer {
    private static final int RANDOM_MAX = 10;
    private static final int FOWARD_POINT = 4;

    private Car[] carList;

    Computer() {}

    public void setCarList(String carName) {
        String[] carNameList = carName.split(",");
        carList = new Car[carNameList.length];
        
        for (int i = 0; i < carNameList.length; i++) {
            carList[i] = new Car(carNameList[i]);
        }
    }

    public int makeRandom() {
        Random r = new Random();
        return r.nextInt(RANDOM_MAX);
    }

    public void showPosition() {
        for (int i = 0; i < carList.length; i++) {
            System.out.print(carList[i].getName() + " : ");
            for (int j = 0; j < carList[i].getPosition(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void checkFoward() {
        for (int i = 0; i < carList.length; i++) {
            if (makeRandom() >= FOWARD_POINT) {
                carList[i].goFoward();
            }
        }
        showPosition();
    }

    public int getWinnerPosition() {
        int winnerPosition = 0;

        for (int i = 0; i < carList.length; i++) {
            if (winnerPosition < carList[i].getPosition()) {
                winnerPosition = carList[i].getPosition();
            }
        }

        return winnerPosition;
    }

    public String[] checkWinner(int winnerPosition) {
        String[] winner = new String[carList.length];
        int cnt = 0;

        for (int i = 0; i < carList.length; i++) {
            if (winnerPosition == carList[i].getPosition()) {
                winner[cnt++] = carList[i].getName();
            }
        }

        return winner;
    }

    public String makeWinnerList(String[] winner) {
        String winnerList = null;

        winnerList = winner[0];
        for (int i = 1; i < carList.length; i++) {
            if (winner[i] != null) {
                winnerList += ", " + winner[i];
            }
        }

        return winnerList;
    }

    public void showResult() {
        int winnerPosition = getWinnerPosition();
        String[] winner = checkWinner(winnerPosition);
        String winnerList = makeWinnerList(winner);

        System.out.println(winnerList + "가 최종 우승했습니다.");
    }
}