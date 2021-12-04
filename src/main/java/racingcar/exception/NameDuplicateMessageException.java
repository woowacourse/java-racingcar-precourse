package racingcar.exception;

import racingcar.resource.message.ErrorMessage;

public class NameDuplicateMessageException extends RacingCarException {

    public NameDuplicateMessageException() {
        super(ErrorMessage.NAME_DUPLICATE_MESSAGE);
    }

}
