/*
 * @(#)Validator.java 2019/12/10
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

package domain;

public interface Validator {
    boolean validateNames(String[] names);

    boolean validateCycles(int cycles);
}
