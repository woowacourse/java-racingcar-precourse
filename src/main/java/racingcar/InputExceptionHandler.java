package racingcar;

import java.util.regex.Pattern;

public class InputExceptionHandler {
    private static final String ERROR_FORMAT = "[ERROR] %s%n";
    private static final String NO_SEPARATOR_ERROR = "자동차 이름을 \"%s\"로 구분하여 입력해주세요.";
    private static final String INVALID_LENGTH_ERROR = "자동차 이름은 1~5자여야 합니다.";
    private static final String SPACE_NAME_ERROR = "자동차 이름은 공백일 수 없습니다.";
    private static final String NOT_NUMERIC_ERROR = "이동 횟수는 양의 정수여야 합니다.";
    private static final String OUT_OF_RANGE_ERROR = "입력값이 정수 범위를 벗어났습니다.";
    private static final String ZERO_OR_LESS_ERROR = "이동 횟수는 0보다 커야 합니다.";

    private static final int CAR_NAME_LENGTH_MINIMUM = 1;
    private static final int CAR_NAME_LENGTH_MAXIMUM = 5;
    private static final String SPACE_REGEX = "^[ 　ㅤ​]+$";
    private static final String NUMERIC_REGEX = "^[0-9]+$";

    private InputExceptionHandler() {}

    public static void validateCarNames(String userInput, String separator) {
        checkContainsSeparator(userInput, separator);
        checkTerminalIsSeparator(userInput, separator);
    }

    private static void checkContainsSeparator(String userInput, String separator) {
        if (!userInput.contains(separator)) {
            printError(String.format(NO_SEPARATOR_ERROR, separator));
        }
    }

    private static void checkTerminalIsSeparator(String userInput, String separator) {
        if (userInput.startsWith(separator) || userInput.endsWith(separator)) {
            printError(INVALID_LENGTH_ERROR);
        }
    }
    
    public static void validateCarNamesArray(String[] carNames) {
        for (String carName : carNames) {
            checkLengthIsOneToFive(carName);
            checkConsistOfSpaceCharacters(carName);
        }
    }

    private static void checkLengthIsOneToFive(String carName) {
        if (carName.length() > CAR_NAME_LENGTH_MAXIMUM 
                || carName.length() < CAR_NAME_LENGTH_MINIMUM) {
            printError(INVALID_LENGTH_ERROR);
        }
    }
    
    private static void checkConsistOfSpaceCharacters(String carName) {
        if (Pattern.matches(SPACE_REGEX, carName)) {
            printError(SPACE_NAME_ERROR);
        }
    }

    public static void validateMoveCount(String userInput) {
        checkIsNumeric(userInput);
        checkIsRangeOfInteger(userInput);
        checkIsGreaterThanZero(userInput);
    }

    private static void checkIsNumeric(String userInput) {
        boolean isNumeric = Pattern.matches(NUMERIC_REGEX, userInput);
        if (!isNumeric) {
            printError(NOT_NUMERIC_ERROR);
        }
    }

    private static void checkIsRangeOfInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException exception) {
            printError(OUT_OF_RANGE_ERROR);
        }
    }

    private static void checkIsGreaterThanZero(String userInput) {
        if (Integer.parseInt(userInput) <= 0) {
            printError(ZERO_OR_LESS_ERROR);
        }
    }

    private static void printError(String error) {
        System.out.printf(ERROR_FORMAT, error);
        throw new IllegalArgumentException();
    }
}