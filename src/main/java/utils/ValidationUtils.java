package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ValidationUtils {
    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";
    private static final String NULL_VALUE_ERROR_MESSAGE = "입력값이 존재하여야 한다.";
    private static final String EXCEED_LENGTH_ERROR_MESSAGE = "이름은 5자 이하여야 한다.";
    private static final String NOT_LETTER_ERROR_MESSAGE = "이름은 문자여야 한다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "같은 이름을 가지면 안된다.";
    private static final String NOT_DIGIT_ERROR_MESSAGE = "시도 횟수는 숫자여야 한다.";
    private static final String LESS_THAN_MIN_ERROR_MESSAGE = "시도 횟수는 최소 1번 이상이여야 한다.";
    private static final String REGEX_ALPHA = "^[a-zA-Z]*$";
    private static final String REGEX_KOREAN = "^[가-힣]*$";
    private static final String REGEX_DIGIT = "^[0-9]*$";
    private static final String MIN_TRY_NUMBER = "1";
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private ValidationUtils() {
    }

    public static void validateCarNameArray(String[] carNameArray) {
        for (int i = 0; i < carNameArray.length; i++) {
            if (carNameArray[i] == "") {
                throw new IllegalArgumentException(ERROR_MESSAGE_HEADER + NULL_VALUE_ERROR_MESSAGE);
            }
            if (isInvalidLength(carNameArray[i])) {
                throw new IllegalArgumentException(ERROR_MESSAGE_HEADER + EXCEED_LENGTH_ERROR_MESSAGE);
            }
            if (isNotLetter(carNameArray[i])) {
                throw new IllegalArgumentException(ERROR_MESSAGE_HEADER + NOT_LETTER_ERROR_MESSAGE);
            }
        }
        if (hasDuplicateValue(carNameArray)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER + DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void validateTryNumber(String tryNumber) {
        if (tryNumber == "") {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER + NULL_VALUE_ERROR_MESSAGE);
        }
        if (isNotDigit(tryNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER + NOT_DIGIT_ERROR_MESSAGE);
        }
        if (tryNumber.compareTo(MIN_TRY_NUMBER) < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER + LESS_THAN_MIN_ERROR_MESSAGE);
        }
    }

    private static boolean isInvalidLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            return true;
        }
        return false;
    }

    private static boolean isNotLetter(String carName) {
        if (Pattern.matches(REGEX_ALPHA, carName) || Pattern.matches(REGEX_KOREAN, carName)) {
            return false;
        }
        return true;
    }

    public static boolean isNotDigit(String tryNumber) {
        if (Pattern.matches(REGEX_DIGIT, tryNumber)) {
            return false;
        }
        return true;
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
