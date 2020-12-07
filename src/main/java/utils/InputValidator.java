package utils;

public class InputValidator {
    private static final char COMMA = ',';
    private static final String INCORRECT_NUMBER_ERROR = "[ERROR] 숫자를 잘못 입력하셨습니다.";
    private static final String NAME_LENGTH_ERROR = "[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.";

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
        validateEndComma(carNames);
        return carNames;
    }

    private static String validateNull(String carNames) {
        if (carNames == null || carNames.equals("")) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
        return carNames;
    }

    private static String validateEndComma(String carNames) {
        if (carNames.charAt(carNames.length() - 1) == COMMA) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
        return carNames;
    }
}
