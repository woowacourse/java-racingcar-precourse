package racingcar.Service;

import racingcar.Constant;

public class NameValidationService {
    public static void isValidNames(String[] input) {
        if (!(isMoreThanZero(input) && doesSpaceExist(input) && isValidLength(input))) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isMoreThanZero(String[] input) {
        if (input == null || input.length < Constant.MINIMUM_NUMBER_OF_CARS_FOR_GAME) {
            System.out.println(Constant.ERROR_NO_NAMES);
            return false;
        }
        return true;
    }

    private static boolean doesSpaceExist(String[] input) {
        for (String i : input) {
            if (i.contains(" ")) {
                System.out.println(Constant.ERROR_NO_SPACE);
                return false;
            }
        }
        return true;
    }

    private static boolean isValidLength(String[] input) {
        for (String i : input) {
            if (i.length() > Constant.MAXIMUM_LENGTH_OF_NAMES) {
                System.out.println(Constant.ERROR_MORE_THAN_FIVE_CHARACTERS);
                return false;
            }
        }
        return true;
    }
}
