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

    public static void checkCarName(String carName) {
        validateCarName(carName);
    }

    private static void validateCarName(String carName) {
        validateLength(carName);
        validateSpace(carName);
    }

    private static void validateLength(String carName) {
        if (carName.length() < 1) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1글자 이상이어야 합니다.");
        }

        if (carName.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자 이하여야 합니다.");
        }
    }

    private static void validateSpace(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름에 공백이 있으면 안됩니다.");
        }
    }
}
