package utils;

public class InputValidator {
    private static final int ZERO = 0;
    private static final String INCORRECT_NUMBER_ERROR = "[ERROR] 시도 횟수로 자연수를 입력해주세요.";
    private static final String NAME_LENGTH_ERROR = "[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.";
    private static final char COMMA = ',';

    private InputValidator() {
    }

    public static int validateInteger(String numbers) {
        try {
            return Integer.parseInt(numbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INCORRECT_NUMBER_ERROR);
        }
    }

    public static String validateInputCarNames(String carNames) {
        validateNull(carNames);
        validateComma(carNames);
        return carNames;
    }

    private static String validateComma(String carNames) {
        if (carNames.charAt(carNames.length()-1) == COMMA) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
        if (carNames.split(String.valueOf(COMMA)).length == ZERO) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
        return carNames;
    }

    private static String validateNull(String carNames) {
        if (carNames.equals("") || carNames == null) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
        return carNames;
    }
}
