package racingcar.domain.validator;

import racingcar.domain.exception.NotNumericException;
import racingcar.domain.exception.ValidationException;

public class RoundValidator extends Validator {

    public static final int MINIMUM_ROUND = 1;

    public static final int MAXIMUM_ROUND = 20;

    public static final String OUT_OF_RANGE_ROUND_MESSAGE =
            String.format("시도 횟수는 %d 이상 %d 이하이어야 합니다. ", MINIMUM_ROUND, MAXIMUM_ROUND);

    @Override
    public void validate(String input) {
        super.validate(input);
        checkNumeric(input);
        checkBound(input);
    }

    private void checkNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NotNumericException(input);
        }
    }

    private void checkBound(String input) {
        int round = Integer.parseInt(input);

        if (round < MINIMUM_ROUND || round > MAXIMUM_ROUND) {
            throw new ValidationException(
                    OUT_OF_RANGE_ROUND_MESSAGE + String.format(input));
        }
    }
}
