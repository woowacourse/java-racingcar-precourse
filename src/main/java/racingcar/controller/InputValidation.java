package racingcar.controller;

import java.util.Arrays;

public class InputValidation {
    private static final int CAR_MIN_LENGTH = 0;
    private static final int CAR_MAX_LENGTH = 5;
    private static final int NUM_RANGE_MINIMUM = 1;

    private static final String BASE_SPLIT = ",";
    private static final String ERROR_CAR_NAME = "[ERROR] 이름은 1~5자 사이이다.";
    private static final String ERROR_NOT_NUM = "[ERROR] 시도 횟수는 숫자여야 한다.";
    private static final String ERROR_NUM_RANGE = "[ERROR] 시도 횟수는 1 이상이다.";

    public static void carNameValidation(String input) {
        String[] carList = input.split(BASE_SPLIT, -1);

        if (!checkCarLength(carList)) {
            throw new IllegalArgumentException(ERROR_CAR_NAME);
        }
    }

    private static boolean checkCarLength(String[] input) {
        for (String s : input) {
            if (s.length() == CAR_MIN_LENGTH || s.length() > CAR_MAX_LENGTH) {
                return false;
            }
        }
        return true;
    }

    public static void tryNumValidation(String input) {
        isNumValidation(input);
        NumRangeValidation(input);
    }

    public static void isNumValidation(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_NOT_NUM);
        }
    }

    public static void NumRangeValidation(String input) {
        int inputNum = Integer.parseInt(input);

        if (inputNum < NUM_RANGE_MINIMUM) {
            throw new IllegalArgumentException(ERROR_NUM_RANGE);
        }
    }
}
