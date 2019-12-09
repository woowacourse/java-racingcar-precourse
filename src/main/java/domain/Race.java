/*
 * Race.java
 *
 * v 0.0.0
 *
 * 2019.12.07
 *
 * Copyright 2019. DunDung all rights reserved.
 */

package domain;

import java.util.Random;

public class Race {
    private static final int MOVE_BOUND = 3;
    private static final int RANDOM_BOUND = 10;
    private static final String NEW_LINE = "\n";

    private final Cars cars;

    public Race(Cars cars) {
        this.cars = cars;
    }

    public void runRace() {
        Random random = new Random();

        for (int index = 0; index < cars.size(); index++) {
            moveCarAccordingToRandomNumber(index, random);
        }
    }

    public RaceResult createRaceResult() {
        StringBuilder builder = new StringBuilder();

        for (int index = 0; index < cars.size(); index++) {
            builder.append(cars.getCarByIndex(index).toString() + NEW_LINE);
        }
        builder.append(NEW_LINE);
        return new RaceResult(builder.toString());
    }

    private void moveCarAccordingToRandomNumber(int index, Random random) {
        if (isCheckMove(random.nextInt(RANDOM_BOUND))) {
            cars.getCarByIndex(index).moveAStepForward();
        }
    }

    private boolean isCheckMove(int random) {
        return random > MOVE_BOUND;
    }
}
