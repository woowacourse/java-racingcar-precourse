/*
 * @(#)RacingRefereeImpl.java 2019/12/10
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

package domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingRefereeImpl implements RacingReferee {

    @Override
    public List<Raceable> distinguishWinners(List<Raceable> raceables) {
        //todo: check convention
        int maxPosition = raceables.stream()
                .map(Raceable::getPosition)
                .max(Integer::compareTo)
                .orElseThrow(IllegalArgumentException::new);

        return raceables.stream().filter(racingCar -> racingCar.getPosition() == maxPosition).sorted().collect(Collectors.toList());
    }
}
