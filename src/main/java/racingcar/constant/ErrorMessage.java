package racingcar.constant;

public enum ErrorMessage {
    CAR_NAME_OVER_SIZE_ERROR("[ERROR] 자동차 이름은 5글자를 넘을 수 없습니다."),
    CAR_NAME_NULL_ERROR("[ERROR] 자동차의 이름을 입력하지 않았습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String print() {
        return message;
    }
}
