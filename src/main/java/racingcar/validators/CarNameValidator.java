package racingcar.validators;

import racingcar.exceptions.CompletelyBlankCarNameException;
import racingcar.exceptions.DuplicatedCarNameException;
import racingcar.exceptions.PartiallyBlankCarNameException;
import racingcar.exceptions.TooLongCarNameException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {
    private static final int MAX_LENGTH_OF_CAR_NAME = 5;
    private static final int ZERO = 0;
    private static final int ONE = 1;

    private CarNameValidator() {
    }

    public static void validateCarNames(List<String> carNames) {
        validateCompletelyBlank(carNames);
        validatePartiallyBlank(carNames);
        validateLengthOfName(carNames);
        validateDuplicateName(carNames);
    }

    private static void validateCompletelyBlank(List<String> carNames) {
        if (isCompletelyBlank(carNames)) {
            throw new CompletelyBlankCarNameException();
        }
    }

    private static boolean isCompletelyBlank(List<String> carNames) {
        return carNames.size() == ONE && carNames.get(ZERO).isEmpty();
    }

    private static void validatePartiallyBlank(List<String> carNames) {
        if (isPartiallyBlank(carNames)) {
            throw new PartiallyBlankCarNameException();
        }
    }

    private static boolean isPartiallyBlank(List<String> carNames) {
        return carNames.stream()
                .anyMatch(String::isEmpty);
    }

    private static void validateLengthOfName(List<String> carNames) {
        if (isOverMaxLength(carNames)) {
            throw new TooLongCarNameException();
        }
    }

    private static boolean isOverMaxLength(List<String> carNames) {
        return carNames.stream()
                .anyMatch((carName) -> carName.length() > MAX_LENGTH_OF_CAR_NAME);
    }

    private static void validateDuplicateName(List<String> carNames) {
        if (hasDuplicatedName(carNames)) {
            throw new DuplicatedCarNameException();
        }
    }

    private static boolean hasDuplicatedName(List<String> carNames) {
        Set<String> names = new HashSet<>(carNames);
        return carNames.size() != names.size();
    }
}
