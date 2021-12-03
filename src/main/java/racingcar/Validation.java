package racingcar;

public class Validation {
    public static void isValidNames(String[] input) {
        if (!(isMoreThanZero(input) && isValidLength(input))) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isMoreThanZero(String[] input) {
        if (input.length < Constant.MINIMUM_NUMBER_OF_CARS_FOR_GAME) {
            System.out.println(Constant.ERROR_NO_NAMES);
            return false;
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

    public static void isValidAttempt(String input) {
        if (!(isInteger(input) && isAttemptMoreThanZero(input))) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println(Constant.ERROR_ATTEMPT_MUST_BE_A_NUMBER);
            return false;
        }
        return true;
    }

    private static boolean isAttemptMoreThanZero(String input) {
        if (Integer.parseInt(input) < Constant.MINIMUM_NUMBER_OF_ATTEMPT) {
            System.out.println(Constant.ERROR_ATTEMPT_MUST_BE_MORE_THAN_ZERO);
            return false;
        }
        return true;
    }
}
