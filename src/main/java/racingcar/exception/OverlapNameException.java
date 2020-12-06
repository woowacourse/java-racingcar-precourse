package racingcar.exception;

public class OverlapNameException extends RuntimeException {
    private static final String OVERLAP_NAME_ERROR_MESSAGE = "[ERROR] 자동차 이름은 서로 겹치지 않게 설정해주세요.";

    public OverlapNameException() {
        super(OVERLAP_NAME_ERROR_MESSAGE);
    }
}