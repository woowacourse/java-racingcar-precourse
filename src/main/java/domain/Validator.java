/*
 * @(#)Validator.java 2019/12/10
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

package domain;

import java.util.List;

public interface Validator {
    boolean validateRaceables(List<Raceable> raceables);
    boolean validateNames(String[] names);

    boolean validateCycles(int cycles);
}
