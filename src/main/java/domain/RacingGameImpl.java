package domain;

import util.RacingPrinter;

import java.util.List;

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
        //todo: check if printResult is good in play
        racingPrinter.printWinners(winners);
    }
    private void start() {
        racingPrinter.printStartSign();
    }
}
