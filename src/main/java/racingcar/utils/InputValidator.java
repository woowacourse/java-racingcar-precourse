package racingcar.utils;

public final class InputValidator {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String COMMA = ",";

    private static final String NOT_IN_COMMA = "자동차 이름을 쉼표(,)로 구분해 적어주세요.";
    private static final String INVALID_NAME_LENGTH = "자동차 5글자 이내로 입력해주세요.";
    private static final String NOT_NUMBER = "시도할 횟수를 숫자로 입력해주세요.";

    private InputValidator() {

    }

    public static void notContainsComma(String input) {
        if (input.length() > MAX_NAME_LENGTH && !input.contains(COMMA)) {
            throw new IllegalArgumentException(NOT_IN_COMMA);
        }
    }

    public static String[] moreThanLenFive(String input) {
        String[] inputList = input.split(COMMA);
        for (String str : inputList) {
            if (str.trim().length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(INVALID_NAME_LENGTH);
            }
        }
        return inputList;
    }

    public static int notNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }
}
