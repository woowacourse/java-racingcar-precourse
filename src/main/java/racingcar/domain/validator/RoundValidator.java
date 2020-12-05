package racingcar.domain.validator;

import racingcar.domain.exception.NotNumericException;
import racingcar.domain.exception.RoundOutOfBoundsException;

public final class RoundValidator extends Validator {

    public static final int MINIMUM_ROUND = 1;

    public static final int MAXIMUM_ROUND = 20;

    @Override
    public void validate(final String input) {
        super.validate(input);
        checkNumeric(input);
        checkBound(input);
    }

    private void checkNumeric(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NotNumericException(input);
        }
    }

    private void checkBound(final String input) {
        final int round = Integer.parseInt(input);

        if (round < MINIMUM_ROUND || round > MAXIMUM_ROUND) {
            throw new RoundOutOfBoundsException(input);
        }
    }
}
