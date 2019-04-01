package com.codemcd.racingcar;

public class Draw {

    public void drawMoveResult(Car[] cars, int carsArraySize) {

        for (int i = 0; i < carsArraySize; ++i) {
            System.out.print(cars[i].getName() + " : ");
            for (int j = 0; j < cars[i].getPosition(); ++j)
                System.out.print("-");
            System.out.println();
        }
    }

    public void drawWhoIsWinners(String[] winners) {
        for (int i = 0; i < winners.length; ++i) {
            System.out.print(winners[i]);
            if (i != winners.length - 1)
                System.out.print(", ");
        }

        System.out.println("가 최종 우승했습니다.");
    }

}
