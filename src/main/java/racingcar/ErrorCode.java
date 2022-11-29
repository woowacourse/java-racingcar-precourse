package racingcar;

public enum ErrorCode {
    NOT_VALID_CAR_COUNT("레이스 할 차의 개수가 2개 이상이어야 합니다."),
    NOT_VALID_CAR_NAME("자동차의 이름은 5자 이하여야 합니다."),
    NOT_TRY_COUNT("숫자를 입력해야 합니다."),
    NOT_VALID_TRY_COUNT("시도 횟수는 1회 이상이어야 합니다.");


    public String getErrorMessage() {
        return errorMessage;
    }

    private static final String ERROR_BEGIN = "[ERROR] ";
    private final String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = ERROR_BEGIN + errorMessage;
    }

    public void throwError() {
        throw new IllegalArgumentException(this.getErrorMessage());
    }

}
