package racingcar;

public enum ErrorMessage {

    INVALID_CAR_NAME_LENGTH("차 이름은 %d자 이상, %d자 이하여야 한다."),
    DUPLICATED_CAR_NAME("차 이름은 중복되지 않아야 한다."),
    INVALID_ATTEMPT_STRING_FORMAT("시도 횟수는 숫자여야 한다."),
    INVALID_ATTEMPT_INTEGER("시도 횟수는 Integer 범위 안이여야 한다."),
    INVALID_ATTEMPT_RANGE("시도 횟수는 %d 이상, %d 이하여야 한다.");

    private static final String ERROR_HEADER = "[ERROR]";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR_HEADER + ' ' + message;
    }
}
