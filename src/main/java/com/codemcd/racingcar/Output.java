/*
 * @(#)Output.java
 * v2.0
 * 2019/04/03
 */

package com.codemcd.racingcar;

/**
 * 게임 진행에 필요한 화면을 출력하는 클래스
 *
 * @author 박성범
 * @version v2.0
 */
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
