package racingcar.domain.error;

public enum ErrorMessage {

    CAR_NAME_NOT_VALID("[ERROR] 차 이름을 잘못 입력하였습니다."),
    CAR_NAME_NOT_DUPLICATE("[ERROR] 차 이름은 중복될 수 없습니다."),
    NUMBER_FORMAT_NOT_VALID("[ERROR] 시도 횟수는 숫자여야 한다."),
    NEGATIVE_NUMBER_NOT_VALID("[ERROR] 시도 횟수는 음수가 아니어야 한다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}