package utils;

public class InputValidator {
    private static final String INCORRECT_NUMBER_ERROR = "[ERROR] 시도 횟수로 숫자를 입력해주세요.";

    private InputValidator() {
    }

    public static int validateInteger(String numbers) {
        try {
            return Integer.parseInt(numbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INCORRECT_NUMBER_ERROR);
        }
    }
}
