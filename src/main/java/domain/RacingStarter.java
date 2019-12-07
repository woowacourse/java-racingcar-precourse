/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */

package domain;

import java.util.ArrayList;

/**
 * 클래스 이름 : RacingStarter.java
 *
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * <p>
 * 날짜 : 2019.12.6 금요일
 */
public class RacingStarter {
    /*
     * RacingStarter 클래스는 입력받은 횟수를 이용하여 경주를 실시한다.
     */
    private static ArrayList<Car> carArrayList = new ArrayList<>();
    private static int roundNumber = 1;
    private static String positionByDash;

    public static ArrayList<Car> RacingStarter(ArrayList<Car> inputCarArrayList, int inputRoundNumber) {
        carArrayList = inputCarArrayList;
        roundNumber = inputRoundNumber;
        controlRacingTotalRound();
        return carArrayList;
    }

    public static void controlRacingTotalRound() {
        System.out.println("실행 결과");
        for (int i = 0; i < roundNumber; i++) {
            controlRacingByRound();
            System.out.print("\n");
        }
    }

    public static void controlRacingByRound() {
        for (Car car : carArrayList) {
            executeRacing(car);
            exchangePositionToDash(car);
            System.out.println(car.getName()+ " : "+ positionByDash);

        }
    }

    public static void executeRacing(Car car) {
        car.moveForward(car.decideGoOrNot(car.getRandomInt()));
    }

    public static void exchangePositionToDash(Car car) {
        positionByDash = new String(new char[car.getPosition()]).replace("\0", "-");
    }

}
