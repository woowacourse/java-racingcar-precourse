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
    private TrackingCenter trackingCenter;

    public RacingCarGame() {
        trackingCenter = new TrackingCenter();
    }

    public void moveCars(ArrayList<Car> cars) {
        for (Car car: cars) {
            car.randomMove();
        }
    }

    public void start(ArrayList<Car> cars, int totalTrial) {
        System.out.println("\n실행 결과");
        for (int trial = 1; trial <= totalTrial; trial++) {
            moveCars(cars);
            trackingCenter.detectPositionsOf(cars);
            trackingCenter.showPositions();
        }
        trackingCenter.showWinners();
    }

    public static void main(String args[]) {
        RacingCarGame racingCarGame = new RacingCarGame();
        RacingManager racingManager = new RacingManager();
        ArrayList<Car> cars = racingManager.getInitializedCars();
        int totalTrial = racingManager.getTotalTrial();

        racingCarGame.start(cars, totalTrial);
    }
}