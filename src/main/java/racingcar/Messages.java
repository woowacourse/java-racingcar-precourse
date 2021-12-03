package racingcar;

public enum Messages {
    COMMA_LOCATION_ERROR_MESSAGE("[ERROR] 쉼표는 이름 사이에 존재해야합니다."),
    NAME_AMOUNT_ERROR_MESSAGE("[ERROR] 자동차 이름은 2개 이상이어야 합니다."),
    NAME_DIGIT_ERROR_MESSAGE("[ERROR] 자동차 이름의 글자수는 5자 이하여야 합니다."),
    DUPLICATED_NAME_ERROR_MESSAGE("[ERROR] 자동차 이름은 중복이 존재하면 안됩니다."),
    CONTAINS_BLANK_ERROR_MESSAGE("[ERROR] 입력값에 빈 칸은 포함될 수 없습니다."),
    ROUND_INPUT_ERROR_MESSAGE("[ERROR] 라운드 입력은 숫자만 가능합니다.");

    private String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
