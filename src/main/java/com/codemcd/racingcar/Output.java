package com.codemcd.racingcar;

public class Output {

    public static void outputMoveResult(Car[] cars) {
        for (int i = 0; i < cars.length; ++i) {
            System.out.print(cars[i].getName() + " : ");
            for (int j = 0; j < cars[i].getPosition(); ++j)
                System.out.print("-");
            System.out.println();
        }
        System.out.println();
    }

    public static void outputWhoIsWinners(String[] winners) {
        for (int i = 0; i < winners.length; ++i) {
            System.out.print(winners[i]);
            if (i != winners.length - 1)
                System.out.print(", ");
        }
        System.out.println("가 최종 우승했습니다.");
    }

}
