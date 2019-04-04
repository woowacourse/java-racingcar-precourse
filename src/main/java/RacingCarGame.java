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
    private String leagueName;

    public RacingCarGame(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void moveCars(ArrayList<Car> cars) {
        for (Car car: cars) {
            car.randomMove();
        }
    }

    public void start(ArrayList<Car> cars, PositionRecorder positionRecorder, int totalTrial) {
        System.out.println("\n실행 결과");
        for (int trial = 1; trial <= totalTrial; trial++) {
            moveCars(cars);
            positionRecorder.recordPositionsOf(leagueName, trial, cars);
        }
    }

    public static void main(String args[]) {
        RacingCarGame racingCarGame = new RacingCarGame("Woowahan Championship");
        RacingManager racingManager = new RacingManager();
        PositionRecorder positionRecorder = new PositionRecorder();
        ArrayList<Car> cars = racingManager.getInitializedCars();
        int totalTrial = racingManager.getTotalTrial();

        racingCarGame.start(cars, positionRecorder, totalTrial);
        positionRecorder.showHistoryOf(racingCarGame.getLeagueName());
        positionRecorder.showWinnersOf(racingCarGame.getLeagueName(), totalTrial);
    }
}