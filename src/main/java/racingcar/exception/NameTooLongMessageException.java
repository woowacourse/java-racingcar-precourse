package racingcar.exception;

import racingcar.resource.message.ErrorMessage;

public class NameTooLongMessageException extends RacingCarException {

    public NameTooLongMessageException() {
        super(ErrorMessage.NAME_TOO_LONG_MESSAGE);
    }

}
