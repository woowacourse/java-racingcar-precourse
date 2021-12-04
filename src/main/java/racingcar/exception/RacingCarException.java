package racingcar.exception;

import racingcar.resource.message.ErrorMessage;

public class RacingCarException extends IllegalArgumentException {

    public RacingCarException(String message) {
        super(ErrorMessage.TAG + message);
    }

}
