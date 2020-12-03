package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidationUtils {
    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";
    private static final String EXCEED_LENGTH_ERROR_MESSAGE = "이름은 5자 이하여야 한다.";
    private static final String NOT_ALPHA_ERROR_MESSAGE = "이름은 영문자여야 한다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "같은 이름을 가지면 안된다.";
    private static final String NOT_DIGIT_ERROR_MESSAGE = "시도 횟수는 숫자여야 한다.";
    private static final String LESS_THAN_MIN_ERROR_MESSAGE = "시도 횟수는 최소 1번 이상이여야 한다.";
    private static final String REGULAR_EXPRESSION_ALPHA = "^[a-zA-Z]*$";
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_TRY_NUMBER = 1;

    private ValidationUtils() {
    }

    public static void validateCarNameArray(String[] carNameArray) {
        for (int i = 0; i < carNameArray.length; i++) {
            if (isInvalidLength(carNameArray[i])) {
                throw new IllegalArgumentException(ERROR_MESSAGE_HEADER + EXCEED_LENGTH_ERROR_MESSAGE);
            }
            if (isNotAlpha(carNameArray[i])) {
                throw new IllegalArgumentException(ERROR_MESSAGE_HEADER + NOT_ALPHA_ERROR_MESSAGE);
            }
        }
        if (hasDuplicateValue(carNameArray)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER + DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static int validateTryNumber(Scanner scanner) {
        if (scanner.hasNext()) {
            int tryNumber = scanner.nextInt();
            if (tryNumber > MIN_TRY_NUMBER) {
                return tryNumber;
            }
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER + LESS_THAN_MIN_ERROR_MESSAGE);
        }
        throw new IllegalArgumentException(ERROR_MESSAGE_HEADER + NOT_DIGIT_ERROR_MESSAGE);
    }

    private static boolean isInvalidLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            return true;
        }
        return false;
    }

    private static boolean isNotAlpha(String carName) {
        if (!Pattern.matches(REGULAR_EXPRESSION_ALPHA, carName)) {
            return true;
        }
        return false;
    }

    private static boolean hasDuplicateValue(String[] carNameArray) {
        List<String> carNameSet = new ArrayList<String>();
        for (int i = 0; i < carNameArray.length; i++) {
            if (carNameSet.contains(carNameArray[i])) {
                return true;
            }
            carNameSet.add(carNameArray[i]);
        }
        return false;
    }
}
