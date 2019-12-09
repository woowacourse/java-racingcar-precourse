/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */

package domain;

import java.util.ArrayList;

/**
 * 클래스 이름 : RacingLogicController.java
 *
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.1
 * <p>
 * 날짜 : 2019.12.8 일요일
 */
public class RacingLogicController {
    /*
     * RacingLogicController 클래스는 레이싱 게임을 실행하는 로직을 담당한다.
     */

    private static ArrayList<Car> carArrayList = new ArrayList<>();
    private static int roundNumber = 1;

    /**
     *  playRacing 메서드에서는 레이싱 게임을 실행하는 로직을 담당한다.
     */
    public static void playRacing() {
        carArrayList = CarNameGenerator.carNameGenerator();
        roundNumber = RoundNumberGetter.controlRoundNumberGetting();
        carArrayList = RacingStarter.RacingStarter(carArrayList, roundNumber);
        WinnerSelector.winnerSelector(carArrayList);

    }

}
