/*
 * @(#)Announcer.java          2019/04/04
 *
 * Copyright (c) 2019 Seungwoo Lee.
 * All rights reserved.
 *
 */

package game;

import domain.Car;

/**
 * Racing Game의 중간 결과와 최종 우승자를 말하는
 * 아나운서 역할을 하는 클래스입니다.
 *
 * @author 이승우
 * @version 1.00 2019년 4월 4일
 */
public class Announcer {
    public static void showRaceProgress(Car[] car) {
        for (int i = 0; i < car.length; i++) {
            car[i].showMoveProgress();
        }
        System.out.println();
    }

    public static void tellWinner(Car[] car) {
        StringBuilder winner = new StringBuilder();
        int max = findMaxPosition(car);

        for (int i = 0; i < car.length; i++) {
            if (car[i].getPosition() == max) {
                winner.append(car[i].getName() + ", ");
            }
        }
        winner.delete(winner.length() - 2, winner.length());
        winner.append("가 최종 우승했습니다.");
        System.out.println(winner);
    }

    public static int findMaxPosition(Car[] car) {
        int maxPosition = -1;

        for (int i = 0; i < car.length; i++) {
            if (maxPosition < car[i].getPosition()) {
                maxPosition = car[i].getPosition();
            }
        }

        return maxPosition;
    }
}
