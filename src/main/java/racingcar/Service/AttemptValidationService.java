package racingcar.Service;

import racingcar.Constant;

public class AttemptValidationService {
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
