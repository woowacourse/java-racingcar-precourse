package racingcar.util;

public enum ErrorMessage {
    ERROR_OUT_OF_LENGTH("[ERROR] 자동차 이름은 1자 이상, 5자 이하만 가능합니다."),
    ERROR_CANNOT_CONTAIN_SPACE("[ERROR] 자동차 이름에는 공백 문자를 포함할 수 없습니다."),
    ERROR_CANNOT_CONTAIN_COMMA_LAST_STRING("[ERROR] 자동차 이름은 쉼표로 끝날 수 없습니다."),
    ERROR_CANNOT_DUPLICATE("[ERROR] 자동차 이름은 중복될 수 없습니다."),
    ERROR_NO_RIVAL("[ERROR] 경주 상대가 없습니다. 다수의 자동차를 입력해야 합니다."),

    ERROR_NOT_NUMBER("[ERROR] 시도 횟수는 숫자여야 합니다."),
    ERROR_OUT_OF_RANGE_NUMBER("[ERROR] 시도 횟수는 1 이상이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
