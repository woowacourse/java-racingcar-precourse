/*
 * @(#)RacingGameConfig.java 2019/12/10
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

package domain;

public class RacingGameConfig {
    public static final String STANDARD_TO_PARSE = ",";
    public static final int MIN_CYCLES = 1;
    public static final int MAX_NAME_LENGTH = 5;
    public static final String POSITION_MARK = "-";
    static final int MIN_NAMES = 2;
    static final int DEFAULT_ID = 0;
    static final int AMOUNT_INCREASE_ID = 1;
    static final int STEP = 1;
    static final int MIN_RANDOM_NUMBER = 0;
    static final int MAX_RANDOM_NUMBER = 9;
    static final int STANDARD_TO_GO = 4;
    static final String[] NOT_ALLOWED_IN_NAME = {" ", "!", "@", "#", "$", "%", "^", "&", "*"};
}
