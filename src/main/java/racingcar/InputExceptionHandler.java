package racingcar;

import java.util.regex.Pattern;

public class InputExceptionHandler {
    private static final String ERROR_FORMAT = "[ERROR] %s%n";
    private static final String NO_DELIMITER_ERROR = "자동차 이름을 \"%s\"로 구분하여 입력해주세요.";
    private static final String INVALID_LENGTH_ERROR = "자동차 이름은 1~5자여야 합니다.";
    private static final String SPACE_NAME_ERROR = "자동차 이름은 공백일 수 없습니다.";

    private static final int CAR_NAME_LENGTH_MINIMUM = 1;
    private static final int CAR_NAME_LENGTH_MAXIMUM = 5;
    private static final String SPACE_REGEX = "^[ 　ㅤ​]+$";

    private InputExceptionHandler() {}

    public static void validateCarNames(String userInput, String delimiter) {
        checkContainsDelimiter(userInput, delimiter);
        checkInputTerminalIsDelimiter(userInput, delimiter);
    }

    private static void checkContainsDelimiter(String userInput, String delimiter) {
        if (!userInput.contains(delimiter)) {
            printError(String.format(NO_DELIMITER_ERROR, delimiter));
        }
    }

    private static void checkInputTerminalIsDelimiter(String userInput, String delimiter) {
        if (userInput.startsWith(delimiter) || userInput.endsWith(delimiter)) {
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
        // TODO 예외처리
    }

    private static void printError(String error) {
        System.out.printf(ERROR_FORMAT, error);
        throw new IllegalArgumentException();
    }
}