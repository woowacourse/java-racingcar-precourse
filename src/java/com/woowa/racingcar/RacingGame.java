/*
 * Class: RacingGame.java
 * Version: 1.0
 * Date: 2019-04-02
 * Author: Kibaek Yoo
 */

package com.woowa.racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class RacingGame {

    private static final String COMMENT_WHEN_PRINT_CHAMPIONS = "가 최종 우승했습니다";
    private ArrayList<Car> carList;
    private int runCount;

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        carList = DataReceiver.getCarListFromUserInput(scanner);
        runCount = DataReceiver.getRunCountFromUserInput(scanner);

        // runCount 만큼 자동차 달리기
        for (int i = 0; i < runCount; i++) {
            progressAllCarsOneTurn();
            System.out.println();
        }

        printChampions();
    }

    /**
     * 모든 자동차를 한턴 진행한다.
     */
    public void progressAllCarsOneTurn() {
        for (int j = 0; j < carList.size(); j++) {
            carList.get(j).tryOneTurn();
        }
    }

    /**
     * @return int 자동차중 최대 position 값
     */
    public int getMaxDistance() {
        int maxPosition = 0;

        for (int i = 0; i < carList.size(); i++) {
            int tmpPosition = carList.get(i).getPosition();
            if (maxPosition < tmpPosition) {
                maxPosition = tmpPosition;
            }
        }
        return maxPosition;
    }

    public ArrayList<Car> getChampions() {
        int maxPosition = getMaxDistance();
        ArrayList<Car> returnCarList = new ArrayList<Car>();

        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getPosition() != maxPosition) {
                continue;
            }

            returnCarList.add(carList.get(i));
        }
        return returnCarList;
    }

    public void printChampions() {
        int maxPosition = getMaxDistance();
        ArrayList<Car> champions = getChampions();

        for (int i = 0; i < champions.size(); i++) {

            if (i != 0) {
                System.out.print(",");
            }
            System.out.print(champions.get(i).getName());
        }
        System.out.println(COMMENT_WHEN_PRINT_CHAMPIONS);
    }
}
