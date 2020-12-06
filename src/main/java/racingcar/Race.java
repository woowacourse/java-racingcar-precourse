package racingcar;

import utils.TextResource;

public class Race {
    private Cars cars;
    private RaceSetting raceSetting;
    private WinnerCondition winnerCondition;
    private RaceStatusListener raceStatusListener;

    public Race(Cars cars, RaceSetting raceSetting, WinnerCondition winnerCondition, RaceStatusListener raceStatusListener) {
        this.cars = cars;
        this.raceSetting = raceSetting;
        this.winnerCondition = winnerCondition;
        this.raceStatusListener = raceStatusListener;
    }

    public void startRace() {
        System.out.println("\n" + TextResource.WORD_RESULT);
        Round round = raceSetting.getRound();
        for (int i = 0; i < round.getRoundValue(); i++) {
            cars.moveAll();
            raceStatusListener.finishRound(cars);
        }
        raceStatusListener.finishGame(winnerCondition.getWinners(cars));
    }

    interface RaceStatusListener {
        void finishRound(Cars participants);

        void finishGame(Cars Winner);
    }
}
