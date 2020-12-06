package racingcar.validator;

import racingcar.exception.RacingCarException;
import racingcar.exception.SpaceInputException;

public class CarValidator {
    private static final int ZERO = 0;

    private CarValidator() {
    }

    static public void validate(String racingCarNames) {
        validateSpaceInput(racingCarNames);
    }

    static private void validateSpaceInput(String racingCarNames) {
        if (racingCarNames.trim().length() == ZERO) {
            throw new SpaceInputException();
        }
    }

}
