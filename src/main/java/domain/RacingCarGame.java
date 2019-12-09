/*
 * RacingCarGame.java
 *
 * v 0.0.0
 *
 * 2019.12.08
 *
 * Copyright 2019. DunDung all rights reserved.
 */

package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private final Cars cars;
    private final RepetitionNumber repetitionNumber;
    private final Race race;
    private List<RaceResult> raceResults = new ArrayList<>();

    public RacingCarGame(Cars cars, RepetitionNumber repetitionNumber) {
        this.cars = cars;
        this.repetitionNumber = repetitionNumber;
        race = new Race(cars);
    }

    public void startGame() {
        for (int count = 0; count < repetitionNumber.getNumber(); count++) {
            race.runRace();
            raceResults.add(race.createRaceResult());
        }
    }

    public RaceResults createRaceResults() {
        return new RaceResults(raceResults);
    }
}
