/*
 * @(#)RacingCarGame.java           2019/04/03
 *
 * Copyright (c) 2019 Deocksoo Kim.
 * java-racingcar, woowacourse, Java, Seoul, KOREA
 * All rights reserved.
 *
 * This software is created for the submission of woowacourse
 * 2nd precourse project. All Copyrights to this code are on
 * woowacourse.
 */

import domain.*;

import java.util.ArrayList;

public class RacingCarGame {
    private RacingManager racingManager;
    private TrackingCenter trackingCenter;
    private ArrayList<Car> cars;
    private int totalTrial = 0;

    public RacingCarGame() {
        racingManager = new RacingManager();
        trackingCenter = new TrackingCenter();
        cars = new ArrayList<Car>();
    }

    public void setCars() {
        cars = racingManager.getInitializedCars();
    }

    public void setTotalTrial() {
        totalTrial = racingManager.getTotalTrial();
    }

    public void start() {
        System.out.println("\n실행 결과");
        for (int trial = 1; trial <= totalTrial; trial++) {
            racingManager.sendMoveSignalsTo(cars);
            trackingCenter.detectPositionsOf(cars);
            trackingCenter.showPositions();
        }
        trackingCenter.showWinners();
    }

    public static void main(String args[]) {
        RacingCarGame racingCarGame = new RacingCarGame();

        racingCarGame.setCars();
        racingCarGame.setTotalTrial();
        racingCarGame.start();
    }
}