package racingcar.validator;

public class CarNamesInputValidator {
    private static final String COMMA = ",";
    private static final String TWO_COMMA = ",,";

    public static void validate(String carNamesInput) {
        validateInputContainsTwoOrMoreComma(carNamesInput);
        validateInputStartsWithComma(carNamesInput);
        validateInputEndsWithComma(carNamesInput);
    }

    private static void validateInputContainsTwoOrMoreComma(String carNamesInput) {
        if (carNamesInput.contains(TWO_COMMA)) {
            throw new IllegalArgumentException("[ERROR] 입력에는 2개 이상의 쉼표가 연속으로 올 수 없습니다.");
        }
    }

    private static void validateInputStartsWithComma(String carNamesInput) {
        if (carNamesInput.trim().startsWith(COMMA)) {
            throw new IllegalArgumentException("[ERROR] 입력은 쉼표로 시작할 수 없습니다.");
        }
    }

    private static void validateInputEndsWithComma(String carNamesInput) {
        if (carNamesInput.trim().endsWith(COMMA)) {
            throw new IllegalArgumentException("[ERROR] 입력은 쉼표로 끝날 수 없습니다.");
        }
    }
}
