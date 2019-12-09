/*
 * @(#)RacingCarFactory.java 2019/12/10
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

package domain;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarFactory implements RaceableFactory {

    private Validator validator;

    public RacingCarFactory(Validator validator) {
        this.validator = validator;
    }

    public List<Raceable> create(String[] names) {
        if (!validator.validateNames(names)) {
            throw new InvalidParameterException("자동차 이름이 옳바르지 않습니다.");
        }

        Random randomGenerator = new Random();
        List<Raceable> raceables = new ArrayList<>();
        for (String name : names) {
            raceables.add(new RacingCar(name, randomGenerator));
        }

        return raceables;
    }

}
