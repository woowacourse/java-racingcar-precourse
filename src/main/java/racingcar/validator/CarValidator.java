package racingcar.validator;

import racingcar.exception.*;

import java.util.Arrays;
import java.util.Optional;

public class CarValidator {
    private static final int ZERO = 0;
    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    public static final String DELIMITER = ",";


    private CarValidator() {
    }

    static public void validate(String racingCarNames) {
        validateSpaceInput(racingCarNames);
        validateDelimiterInput(racingCarNames);
        validateNameLength(racingCarNames);
        validateInputWithoutName(racingCarNames);
        valiateNameDuplication(racingCarNames);
    }

    static private void validateSpaceInput(String racingCarNames) {
        if (racingCarNames.trim().length() == ZERO) {
            throw new SpaceInputException();
        }
    }

    static private void validateDelimiterInput(String racingCarNames) {
        if (!racingCarNames.contains(DELIMITER)) {
            throw new DelimiterInputException();
        }
    }

    static private void validateNameLength(String racingCarNames) {
        Optional<String> first = Arrays.stream(racingCarNames.split(DELIMITER))
                .filter(name
                        -> name.trim().length() < MINIMUM_NAME_LENGTH || name.trim().length() > MAXIMUM_NAME_LENGTH)
                .findFirst();
        if (first.isPresent()) {
            throw new InvalidNameLengthException();
        }
    }

    static private void validateInputWithoutName(String racingCarNames) {
        if (racingCarNames.split(DELIMITER).length == ZERO) {
            throw new InputWithoutNameException();
        }
    }

    static private void valiateNameDuplication(String racingCarNames) {
        boolean duplicated = Arrays.stream(racingCarNames.split(DELIMITER))
                .distinct()
                .count() != racingCarNames.split(DELIMITER).length;
        if (duplicated) {
            throw new NameDuplicationException();
        }
    }
}
