package racingcar.util;

public class VerificationUtil {

    private VerificationUtil() {
    }

    public static void validatePositiveNumber(String input) {
        try {
            int number = Integer.parseInt(input);

            if (number <= 0) {
                throw new IllegalArgumentException("[ERROR] 양수를 입력해주세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    public static void checkCarName(String input) {
        validateLength(input);
    }

    private static void validateLength(String input) {
        if(input.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자 이하여야 합니다.");
        }
    }
}
