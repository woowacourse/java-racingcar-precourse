package racingcar.exception;

import racingcar.resource.message.ErrorMessage;

public class CountNotNumberMessageException extends RacingCarException {

    public CountNotNumberMessageException() {
        super(ErrorMessage.COUNT_NOT_NUMBER_MESSAGE);
    }

}
