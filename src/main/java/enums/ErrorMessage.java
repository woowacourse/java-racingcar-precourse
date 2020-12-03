package enums;

public enum ErrorMessage {
    NUMBER_FORMAT("[ERROR] 시도 횟수는 숫자여야 한다."),
    NEGATIVE_NUMBER("[ERROR] 음수는 절대값이 입력됩니다."),
    OVER_MAXIMUM_NAME_LENGTH("[ERROR] 이름은 "
                        + GameProcess.MAXIMUM_NAME_LENGTH.getValue()
                        + "자까지 출력됩니다."),
    BLANK_NAME("[ERROR] 이름이 공백인 경우 미입력 처리됩니다."),
    NAME_WITH_FORE_AND_AFT_BLANK("[ERROR] 이름 앞, 뒤의 공백은 제거됩니다.");

    String message = "";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
