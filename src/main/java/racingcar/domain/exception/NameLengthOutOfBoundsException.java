package racingcar.domain.exception;

import racingcar.domain.validator.NameValidator;

public class NameLengthOutOfBoundsException extends ValidationException {

    public static final String OUT_OF_BOUNDS_MESSAGE =
            String.format("자동차 이름은 %d글자 이상 %d글자 이하이어야 합니다. ",
                    NameValidator.MINIMUM_NAME_LENGTH, NameValidator.MAXIMUM_NAME_LENGTH);

    public static final String INPUT_NAME_LENGTH_MESSAGE = "자동차 이름 %s의 길이는 %d글자입니다.";

    public NameLengthOutOfBoundsException(String carName, int carNameLength) {
        super(OUT_OF_BOUNDS_MESSAGE +
                String.format(INPUT_NAME_LENGTH_MESSAGE, carName, carNameLength));
    }
}
