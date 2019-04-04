/*
 * Constants.java
 * version 1.0
 * 2019.04.04
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package racingcar.util;

/**
 * Constants holds final int and String used across classes.
 */
public class Constants {

    public static final int NAME_MAX_LENGTH = 5;
    public static final int NAME_MIN_TRIAL = 1;

    public static final String NAME_DELIMINATOR = ",";

    public static final int NUMBER_LOWER_BOUND = 0;
    public static final int NUMBER_UPPER_BOUND = 9;

    /* cars go forward if number is >= bound */
    public static final int NUMBER_FORWARD_BOUND = 4;

    public static final String WRONG_CAR_NAME_WARNING =
            "5글자 이하의 이름을 사용해주세요.";
    public static final String EMPTY_CAR_NAME_WARNING =
            "1글자 이상의 이름을 사용해주세요.";
    public static final String CAR_COUNT_WARNING =
            "중복 없이 1개 이상의 자동차 이름을 입력하세요.";
    public static final String WRONG_TRIAL_NUMBER_WARNING =
            "1 이상의 수를 입력해주세요";

    public static final String GET_CAR_NAME_GUIDE =
            "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String GET_TRIAL_NUMBER_GUIDE =
            "시도할 횟수는 몇회인가요?";
    public static final String PRINT_RESULT_GUIDE =
            "\n실행 결과";
    public static final String PRINT_FINAL_RESULT_GUIDE =
            "가 최종 우승했습니다.";
}
