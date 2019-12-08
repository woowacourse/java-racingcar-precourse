/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */

package domain;

import java.util.ArrayList;

/**
 * 클래스 이름 : WinnerSelector.java
 *
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * <p>
 * 날짜 : 2019.12.8 일요일
 */
public class WinnerSelector {
    /*
     * WinnerSelector 클래스에서는 경주 결과를 이용하여 승리자를 선택한다.
     */

    private static ArrayList<Car> carArrayList = new ArrayList<>();
    private static int topScore = 0;
    private static ArrayList<String> winnerArrayList = new ArrayList<>();

    /**
     * 경주 결과가 담긴 ArrayList를 받고 우승자를 선발하는 로직을 수행하는 메서드.
     */
    public static void winnerSelector(ArrayList<Car> inputArrayList) {
        carArrayList = inputArrayList;
        getTopScore();
        getWinner();
        printWinner();
    }

    /**
     * 경주 결과가 담긴 ArrayList를 이용하여 최다 전진 횟수를 구하는 메서드.
     */
    public static void getTopScore() {
        for (Car car : carArrayList) {
            if (car.getPosition() > topScore) {
                topScore = car.getPosition();
            }
        }
    }

    /**
     * 최다 전진 횟수를 이용하여 우승자(복수 가능)를 구하는 메서드.
     */
    public static void getWinner() {
        for (Car car : carArrayList) {
            if (car.getPosition() == topScore) {
                winnerArrayList.add(car.getName());
            }
        }
    }

    /**
     * 우승자를 포멧에 맞추어 출력하는 메서드.
     */
    public static void printWinner() {
        String winners = String.join(", ", winnerArrayList);
        System.out.println(winners + "가 최종 우승했습니다.");

    }

}
