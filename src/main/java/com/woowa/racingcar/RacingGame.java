package com.woowa.racingcar;

import java.util.ArrayList;

public class RacingGame {

    private ArrayList<Car> carList;
    private int runCount;

    /**
     * 모든 자동차를 한턴 진행한다.
     */
    public void progressAllCarsOneTurn() {
        for (int j = 0; j < carList.size(); j++) {
            carList.get(j).tryOneTurn();
        }
    }
}
