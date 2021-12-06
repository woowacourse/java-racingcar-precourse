package racingcar.validation;

public enum ErrorCode {
    // common
    IS_NULL("[ERROR] 널 값이 입력되었습니다."),

    // for car name input
    NOT_ALLOW_CHAR("[ERROR] 허용하지 않은 문자가 포함된 입력값입니다."),
    NOT_ALLOW_LENGTH("[ERROR] 입력값의 길이가 올바르지 못합니다."),
    IS_DUPLICATED("[ERROR] 중복된 이름이 존재합니다."),

    // for round time input
    FOUND_NOT_NUMBER("[ERROR] 횟수에 숫자 외 다른 문자가 입력되었습니다."),
    OUT_OF_INTEGER_RANGE("[ERROR] 정상적인 정수 입력 범위를 벗어났습니다.");

    private String detail;

    ErrorCode(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }
}
