package racingcar.domain.race.exception;

public class AlreadyCompleteException extends RuntimeException {

    private static final String MESSAGE = "[ERROR] 이미 완료된 경기입니다.";

    public AlreadyCompleteException() {
        super(MESSAGE);
    }
}
