package racingcar.validator;

import racingcar.exception.DelimiterInputException;
import racingcar.exception.RacingCarException;
import racingcar.exception.SpaceInputException;

public class CarValidator {
    private static final int ZERO = 0;
    public static final String DELIMITER = ",";

    private CarValidator() {
    }

    static public void validate(String racingCarNames) {
        validateSpaceInput(racingCarNames);
        validateDelimiterInput(racingCarNames);
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
}
