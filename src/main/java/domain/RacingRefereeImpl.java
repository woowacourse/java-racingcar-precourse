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

    private Validator validator;

    public RacingRefereeImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public List<Raceable> distinguishWinners(List<Raceable> raceables) {
        if (!validator.validateRaceables(raceables)) {
            throw new IllegalArgumentException("입력된 racebales가 null이거나 비어있습니다.");
        }

        int maxPosition = raceables.stream()
                .map(Raceable::getPosition)
                .max(Integer::compareTo)
                .orElseThrow(IllegalArgumentException::new);

        return raceables.stream().filter(racingCar -> racingCar.getPosition() == maxPosition).sorted().collect(Collectors.toList());
    }
}
