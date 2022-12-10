package racingcar.utils;

public enum ErrorMessage {
    INVALID_CAR_NAME("자동차이름은 5자 이하만 가능합니다."),
    INVALID_CAR_GROUP("잘못된 CarGroup을 참조하고있습니다.");
    public final String message;

    private static final String prefix = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }
}
