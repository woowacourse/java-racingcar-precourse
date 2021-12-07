package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public static void validateCarNamesInput(String[] names) {
        for (String name : names) {
            validateLength(name);
        }
        validateExistDuplicateName(names);
    }

    public static void validateTryNumber(String input) {
        validateStringIsNumber(input);
        validateNumberIsMoreThanZero(Integer.parseInt(input));
    }

    private static void validateStringIsNumber(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(RacingCarConstant.ERROR_PREFIX_MESSAGE + "숫자여야 한다.");
        }
    }

    private static void validateNumberIsMoreThanZero(int number) {
        if (number < 1) throw new IllegalArgumentException(RacingCarConstant.ERROR_PREFIX_MESSAGE + "1 이상의 숫자여야 한다.");
    }

    private static void validateLength(String name) {
        if (name.length() > RacingCarConstant.CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(RacingCarConstant.ERROR_PREFIX_MESSAGE + "자동차의 이름은 " + RacingCarConstant.CAR_NAME_MAX_LENGTH + "자 이하여야 한다.");
        }
    }

    private static void validateExistDuplicateName(String[] nameList) {
        Set<String> set = new HashSet<>(Arrays.asList(nameList));
        if (set.size() != nameList.length)
            throw new IllegalArgumentException(RacingCarConstant.ERROR_PREFIX_MESSAGE + "중복된 자동차의 이름을 입력할 수 없다.");
    }
}