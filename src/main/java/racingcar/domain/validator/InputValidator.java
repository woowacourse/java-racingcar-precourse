/*
 * InputValidator.java
 *
 * version 1.0
 *
 * 2020/12/07
 *
 * Copyright (c) 2020 Junhyoung Park
 */

package racingcar.domain.validator;


import java.util.ArrayList;

public class InputValidator {
    private static final String OUT_OF_RANGE = "[ERROR] 자동차 이름의 길이는 5이하 여야 합니다.";
    private static final String DUPLICATE = "[ERROR] 중복된 자동차 이름이 있습니다.";
    private static final String NUMBER_OF_ATTEMPTS = "[ERROR] 시도 횟수는 숫자여야 합니다.";
    private static final String EXACT_FORMAT = "[ERROR] 정확한 형식을 입력하세요.";

    public static ArrayList<String> filterCarName(final ArrayList<String> carNames) {
        if (NameValidator.isOutOfRange(carNames)) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
        if (NameValidator.isDuplicated(carNames)) {
            throw new IllegalArgumentException(DUPLICATE);
        }
        if (NameValidator.isEmpty(carNames)) {
            throw new IllegalArgumentException(EXACT_FORMAT);
        }
        return carNames;
    }

    public static int filterNumberOfAttempts(final String input) {
        if (CountValidator.isNumber(input)) {
            throw new IllegalArgumentException(NUMBER_OF_ATTEMPTS);
        }
        return Integer.parseInt(input);
    }
}
