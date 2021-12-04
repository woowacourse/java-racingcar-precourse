package racingcar.exception;

import racingcar.resource.message.ErrorMessage;

public class NameEmptyMessageException extends RacingCarException {

    public NameEmptyMessageException() {
        super(ErrorMessage.NAME_EMPTY_MESSAGE);
    }

}
