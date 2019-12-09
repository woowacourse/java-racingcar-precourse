/*
 * RaceResults.java
 *
 * v 0.0.0
 *
 * 2019.12.08
 *
 * Copyright 2019. DunDung all rights reserved.
 */

package domain;

import java.util.List;

public class RaceResults {
    private final List<RaceResult> raceResults;

    public RaceResults(List<RaceResult> raceResults) {
        this.raceResults = raceResults;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (RaceResult raceResult : raceResults) {
            builder.append(raceResult.getRaceResult());
        }
        return builder.toString();
    }
}
