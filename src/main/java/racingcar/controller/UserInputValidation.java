package racingcar.controller;

import java.util.Arrays;

public class UserInputValidation {

    public static void carNameValidation(String input) {
        String[] carList = input.split(",", -1);

        if (!checkCarLength(carList)) {
            throw new IllegalArgumentException();
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

}
