package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;

public class VerificationUtil {

    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private VerificationUtil() {
    }

    public static void validateAttemptNumber(String input) {
        int validatedNumber = getValidatedNumber(input);

        validatePositiveNumber(validatedNumber);
    }

    public static void validateDuplication(String[] carNames) {
        HashSet<String> hashStrings = new HashSet<>(Arrays.asList(carNames));

        if (hashStrings.size() < carNames.length) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 중복되면 안됩니다.");
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
        if (carName.length() < CAR_NAME_MIN_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1글자 이상이어야 합니다.");
        }

        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자 이하여야 합니다.");
        }
    }

    private static void validateSpace(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름에 공백이 있으면 안됩니다.");
        }
    }

    private static int getValidatedNumber(String input) {
        try {
            int number = Integer.parseInt(input);

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private static void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 양수를 입력해주세요.");
        }
    }
}
