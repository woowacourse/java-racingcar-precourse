package racingcar.domain.validator;

import racingcar.domain.ValidationException;

public class RoundValidator extends Validator {

    public static final int MINIMUM_ROUND = 1;

    public static final int MAXIMUM_ROUND = 20;

    public static final String NOT_NUMERIC_MESSAGE = "시도 횟수는 숫자여야 합니다. ";

    public static final String OUT_OF_RANGE_ROUND_MESSAGE =
            String.format("시도 횟수는 %d 이상 %d 이하이어야 합니다. ", MINIMUM_ROUND, MAXIMUM_ROUND);

    public static final String INPUT_ROUND_FORMAT = "입력한 값은 %s 입니다";

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
            throw new ValidationException(
                    NOT_NUMERIC_MESSAGE + String.format(INPUT_ROUND_FORMAT, input));
        }
    }

    private void checkBound(String input) {
        int round = Integer.parseInt(input);

        if (round < MINIMUM_ROUND || round > MAXIMUM_ROUND) {
            throw new ValidationException(
                    OUT_OF_RANGE_ROUND_MESSAGE + String.format(INPUT_ROUND_FORMAT, input));
        }
    }
}
