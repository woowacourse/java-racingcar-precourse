package domain;

import util.RacingPrinter;

import java.util.List;

public class RacingGameImpl implements RacingGame {

    private List<RacingCar> racingCars;
    private RacingReferee racingReferee;
    private RacingPrinter racingPrinter;

    public RacingGameImpl(List<RacingCar> racingCars, RacingReferee racingReferee, RacingPrinter racingPrinter) {
        this.racingCars = racingCars;
        this.racingReferee = racingReferee;
        this.racingPrinter = racingPrinter;
    }

    public void play(int cycles) {
        start();
        for (int i = 0; i < cycles; i++) {
            for (RacingCar racingCar : racingCars) {
                racingCar.race();
                racingPrinter.printStateOfRacingCar(racingCar);
            }
            racingPrinter.printOneCycleFinished();
        }

        List<RacingCar> winners = racingReferee.distinguishWinners(racingCars);
        //todo: check if printResult is good in play
        racingPrinter.printWinners(winners);
    }
    private void start() {
        racingPrinter.printStartSign();
    }
}
