package racingcar.domain.validator;

import racingcar.domain.CustomIllegalArgumentException;

public class RoundValidator extends Validator {

    public static final String NOT_NUMERIC_MESSAGE = "시도 횟수는 숫자여야 한다.";

    public static final String OUT_OF_BOUND_ROUND_MESSAGE = "시도 횟수는 1 이상 20 이하이어야 합니다.";

    public static final int MINIMUN_ROUND = 1;

    public static final int MAXIMUM_ROUND = 20;

    @Override
    public void validate(String input) {
        super.validate(input);
        checkNumeric(input);
    }

    private void checkNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new CustomIllegalArgumentException(NOT_NUMERIC_MESSAGE);
        }
    }
}
