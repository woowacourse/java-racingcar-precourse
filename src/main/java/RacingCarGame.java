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
        this.racingManager = new RacingManager();
        this.trackingCenter = new TrackingCenter();
        this.cars = new ArrayList<Car>();
    }

    public void setCars() {
        this.cars = this.racingManager.getInitializedCars();
    }

    public void setTotalTrial() {
        this.totalTrial = this.racingManager.getTotalTrial();
    }

    public void start() {
        System.out.println("\n실행 결과");
        for (int trial = 1; trial <= totalTrial; trial++) {
            this.racingManager.sendMoveSignalsTo(cars);
            this.trackingCenter.detectPositionsOf(cars);
            this.trackingCenter.showPositions();
        }
        this.trackingCenter.showWinners();
    }

    public static void main(String args[]) {
        RacingCarGame racingCarGame = new RacingCarGame();

        racingCarGame.setCars();
        racingCarGame.setTotalTrial();
        racingCarGame.start();
    }
}