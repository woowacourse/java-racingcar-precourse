/*
 * @(#)RacingGameImpl.java 2019/12/10
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

package domain;

import java.util.List;

import util.RacingPrinter;

public class RacingGameImpl implements RacingGame {

    private List<Raceable> raceables;
    private RacingReferee racingReferee;
    private RacingPrinter racingPrinter;

    public RacingGameImpl(List<Raceable> raceables, RacingReferee racingReferee, RacingPrinter racingPrinter) {
        this.raceables = raceables;
        this.racingReferee = racingReferee;
        this.racingPrinter = racingPrinter;
    }

    public void play(int cycles) {
        start();
        for (int i = 0; i < cycles; i++) {
            for (Raceable raceable : raceables) {
                raceable.race();
                racingPrinter.printStateOfRacingCar(raceable);
            }
            racingPrinter.printOneCycleFinished();
        }

        List<Raceable> winners = racingReferee.distinguishWinners(raceables);
        racingPrinter.printWinners(winners);
    }

    private void start() {
        racingPrinter.printStartGameSign();
    }
}
