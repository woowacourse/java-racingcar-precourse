package domain;

public enum InputError {
    BLANK("이름이 올바르게 않은 자동차가 있습니다. 공백 등이 입력되지 않았는지 다시 확인해주세요."),
    COUNT_OF_CARS("경기를 위한 자동차 이름을 2개 이상 입력해주세요."),
    LONG_NAME("자동차의 이름은 %자 이하로 입력해주세요"),
    DUPLICATED("자동차의 이름은 중복되지 않도록 입력해주세요."),
    NOT_INTEGER("시도 횟수는 정수로 입력해주세요."),
    SIZE_OF_INTEGER("시도 횟수는 1 이상의 정수로 입력해주세요."),
    PASS("");

    private String message;

    InputError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int len) {
        if (message.contains("%")) {
            return message.replace("%", String.valueOf(len));
        }
        return message;
    }
}
