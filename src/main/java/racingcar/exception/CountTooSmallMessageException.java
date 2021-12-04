package racingcar.exception;

import racingcar.resource.message.ErrorMessage;

public class CountTooSmallMessageException extends RacingCarException {

    public CountTooSmallMessageException() {
        super(ErrorMessage.COUNT_TOO_SMALL_MESSAGE);
    }

}
