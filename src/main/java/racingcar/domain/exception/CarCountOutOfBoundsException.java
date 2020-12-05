package racingcar.domain.exception;

import racingcar.domain.validator.NameValidator;

public final class CarCountOutOfBoundsException extends ValidationException {

    public static final String OUT_OF_BOUNDS_MESSAGE =
            String.format("자동차의 대수는 %d 이하이어야 합니다.", NameValidator.MAXIMUM_CAR_COUNT);

    public static final String INPUT_CAR_COUNT_MESSAGE = "입력한 자동차의 대수는 %d 입니다";

    public CarCountOutOfBoundsException(final int carCount) {
        super(OUT_OF_BOUNDS_MESSAGE + String.format(INPUT_CAR_COUNT_MESSAGE, carCount));
    }
}
