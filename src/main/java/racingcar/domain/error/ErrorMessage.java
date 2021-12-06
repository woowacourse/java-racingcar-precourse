package racingcar.domain.error;

public enum ErrorMessage {

    CAR_NAME_NOT_DUPLICATE("[ERROR] 차 이름은 중복될 수 없다."),
    CAR_NAME_EMPTY("[ERROR] 비어 있는 차 이름이 존재 한다."),
    CAR_NAME_BLANK("[ERROR] 공백을 가진 차 이름이 존재 한다."),
    CAR_NAME_OVER_LENGTH("[ERROR] 차 이름의 길이는 5이하 이다."),
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