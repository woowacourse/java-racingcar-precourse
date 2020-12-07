package utils;

import static utils.ConstantUtils.*;

public class ValidatorUtils {

    private ValidatorUtils() {

    }

    public static void checkCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME) {
                throw new IllegalArgumentException(OVER_FIVE_LETTERS);
            }
            if (carName.length() < MIN_CAR_NAME) {
                throw new IllegalArgumentException(EMPTY_LETTER);
            }
        }
    }

    public static void checkNumber(String num) {
        try {
            int number = Integer.parseInt(num);
            if (number < MIN_LAP) {
                throw new IllegalArgumentException(MUST_BE_POSITIVE_INTEGER);
            }
        } catch (NumberFormatException n) {
            throw new IllegalArgumentException(MUST_BE_NUMBER);
        }
    }
}
