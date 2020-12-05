package racingcar.domain.exception;

import racingcar.domain.validator.RoundValidator;

public class RoundOutOfBoundsException extends ValidationException {

    public static final String OUT_OF_RANGE_ROUND_MESSAGE =
            "시도 횟수는 %d 이상 %d 이하이어야 합니다. 입력한 값은 %s 입니다.";

    public static final String OVER_MAX_MESSAGE =
            String.format("시도 횟수가 %d을 넘었습니다.", RoundValidator.MAXIMUM_ROUND);

    public RoundOutOfBoundsException() {
        super(OVER_MAX_MESSAGE);
    }

    public RoundOutOfBoundsException(String round) {
        super(String.format(OUT_OF_RANGE_ROUND_MESSAGE, RoundValidator.MINIMUM_ROUND,
                RoundValidator.MAXIMUM_ROUND, round));
    }
}
