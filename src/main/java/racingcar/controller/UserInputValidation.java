package racingcar.controller;

import java.util.Arrays;

public class UserInputValidation {

    public static void carNameValidation(String input) {
        String[] carList = input.split(",", -1);

        if (!checkCarLength(carList)) {
            throw new IllegalArgumentException("[ERROR] 이름은 1~5자 사이이다.");
        }
    }

    private static boolean checkCarLength(String[] input) {
        for (String s : input) {
            if (s.length() == 0 || s.length() > 5) {
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
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }
    }

    public static void NumRangeValidation(String input) {
        int inputNum = Integer.parseInt(input);

        if (inputNum < 1) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상이다.");
        }
    }
}
